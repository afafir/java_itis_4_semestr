package interpretor;

import interpretor.response.Response;
import model.Node;

import java.io.IOException;


public class InterpreterClient {
    private static final String ADD = "add";
    private static final String GET = "get";
    private static final String DELETE = "delete";
    private static final String SAVE = "save";

    Node root;

    InterpreterContext context;

    public InterpreterClient(Node root){
        this.root = root;
        context = new InterpreterContext(root);
    }

    public Response<?> interpret(String str) throws IOException {
        String command = str.substring(0, str.indexOf(" "));
        String[] payload = str.substring(str.indexOf(" ")+1).split(";");
        System.out.println(payload[0]);
        switch (command){
            case ADD:
                return context.add(payload);
            case GET:
                return context.returnChilds(payload);
            case DELETE:
                return context.delete(payload);
            case SAVE:
                return context.save(payload);//принимает формат сохранения и название файла
            default:
                return new Response<>("failure", "unrecognized command");
        }



    }
}
