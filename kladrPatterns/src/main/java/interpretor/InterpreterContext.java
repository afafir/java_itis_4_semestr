package interpretor;

import interpretor.response.Response;
import iterators.Iterator;
import model.Kladr;
import model.Node;
import util.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class InterpreterContext {

    Node root;

    public InterpreterContext(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public Response<List> returnChilds(String[] params) {
        Type type = Type.valueOf(params[0]);
        String name = params[1];
        Node parent = null;
        Iterator kladrIterator = root.bfsIterator();
        while (kladrIterator.hasNext()) {
            Node currNode = (Node) kladrIterator.next();
            if (currNode.getType().equals(type) && currNode.getName().equals(name)) {
                parent = currNode;
                break;
            }
        }
        if (parent == null) {
            return new Response<List>("return", new ArrayList());
        } else
            return new Response<List>("return", parent.getChildren());
    }

    public Response<String> delete(String[] payload) {
        String[] address = payload[0].split(",");
        Iterator<Node> iterator = root.dfsIterator();
        Node toDelete = findNode(address);
        if (toDelete != null) {
            if (toDelete.getParent()!= null) {
                toDelete.getParent().getChildren().remove(toDelete);
            }else root = null;
            return new Response<>("success", "Successfully deleted");
        }else return new Response<>("failure","node can't be found");
    }

    public Response<String> add(String[] params) {
        String[] address = params[0].split(",");
        String name = params[1];
        String typeStr = params[2];
        Type type = Type.valueOf(typeStr);
        int priority = Integer.valueOf(params[3]);
        Iterator<Node> iterator = root.dfsIterator();
        Node parent = findNode(address);
        if (parent != null) {
            Node child = Node.getBuilder()
                    .setParent(parent)
                    .setName(name)
                    .setType(type)
                    .setPriority(priority).build();
            if (parent.getChildren() == null) {
                parent.setChildren(new ArrayList<Node>(Arrays.asList(child)));
                return new Response<>("success", "Success");
            }
            Optional<Node> first = parent.getChildren().stream()
                    .filter(x -> x.getName().equals(child.getName()) && x.getType().equals(child.getType()))
                    .findFirst();
            if (first.isPresent()) {
                return new Response<>("exist", "exist");
            }
            parent.getChildren().add(child);
            return new Response<>("success", "Success");
        }
        return new Response<>("failure", "failure");
    }


    private Node findNode(String[] address) {
        Iterator<Node> iterator = root.dfsIterator();
        while (iterator.hasNext()) {
            Node lastAdrr;
            if ((lastAdrr = iterator.next()).getName().equals(address[address.length - 1])) {
                Node parent = lastAdrr;
                for (int i = address.length - 2; i >= 0; i--) {
                    parent = parent.getParent();
                    if (!parent.getName().equals(address[i])) {
                        lastAdrr = null;
                        break;
                    }
                }
            } else {
                lastAdrr = null;
                continue;
            }
            if (lastAdrr != null) {
                return lastAdrr;
            }
        }
        return null;
    }


}
