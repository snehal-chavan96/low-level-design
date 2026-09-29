
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

public class DocEditor {
    public static void main(String[] args){
        DocumentEditor editor = new DocumentEditor();
        editor.addText("Hello, world!");
        editor.addImage("picture.jpg");
        editor.addText("This is a document editor.");

        System.out.println(editor.renderDocument());

        editor.saveToFile();
    }
}

class DocumentEditor{
    private List<String> documentElements;
    private String renderedDocument;

    public DocumentEditor(){
        documentElements = new ArrayList<>();
        renderedDocument = "";
    }

    public void addText(String text){
        documentElements.add(text);
    }

    public void addImage(String imagePath){
        documentElements.add(imagePath);
    }

    public String renderDocument(){
        if(renderedDocument.isEmpty()){
            StringBuilder res = new StringBuilder();
            for(String ele : documentElements){
                if(ele.length() > 4 && (ele.endsWith(".jpg") || ele.endsWith(".png"))){
                    res.append("[Image: ").append(ele).append("]\n");
                }else{
                    res.append(ele).append("\n");
                }
            }

            renderedDocument = res.toString();
        }
        return renderedDocument;
    }

    public void saveToFile(){
        try{
            FileWriter writer = new FileWriter("document-editor/document.txt");
            writer.write(renderDocument());
            writer.close();

            System.out.println("Document saved to document.txt");
        }
        catch(IOException e){
            System.out.println("Error: Unable to open file for writing.");
        }
    }
}
