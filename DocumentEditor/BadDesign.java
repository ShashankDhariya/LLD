
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
class BadDesign {
    public static void main(String[] args) {
        DocumentEditor documentEditor = new DocumentEditor();

        documentEditor.addText("Hello");
        documentEditor.addImage("Picture.jpg");
        documentEditor.addText("Now that's it");

        System.out.println(documentEditor.renderDocument());

        documentEditor.saveToFile();
    }
}

class DocumentEditor {
    List<String> docElements = new ArrayList<>();
    String renderDocument = "";

    public void addText(String txt) {
        docElements.add(txt);
    }

    public void addImage(String path) {
        docElements.add(path);
    }

    public String renderDocument() {
        if(renderDocument.length() == 0) {
            String res = "";
            for(String a: docElements) {
                if(a.length() > 4 && (a.endsWith(".jpg")) || a.endsWith(".png")) {
                    res += "Image: " + a + "\n";
                }

                else 
                    res += a + "\n";
            }

            renderDocument = res;
        }

        return renderDocument;
    }

    void saveToFile() {
        System.out.println("Saving to File");
    }
}