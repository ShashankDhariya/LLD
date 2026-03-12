
import java.util.ArrayList;
import java.util.List;

class BetterDesign {
    public static void main(String[] args) {
        Document doc = new Document();
        Persistence db = new SaveToDB();

        DocumentEditor editor = new DocumentEditor(doc, db);

        editor.addText("Hello");
        editor.addNewLine();
        editor.addText("I am learning System Design");
        editor.addTabLine();
        editor.addText("Parrot.jpg");

        System.out.println(editor.renderDocument());

        editor.saveDocument();
    }
}

interface DocumentElement {
    public String render();
}

class TextElement implements DocumentElement {
    private String text;
    public TextElement(String text) {
        this.text = text;
    }

    @Override
    public String render() {
        return text;
    }
}

class ImageElement implements DocumentElement {
    private String imagePath;
    public ImageElement(String imagePath) {
        this.imagePath = imagePath;
    }

    public String render() {
        return imagePath;
    }
}

class NewLineElement implements DocumentElement {
    @Override
    public String render() {
        return "\n";
    }
}

class TabSpaceElement implements DocumentElement {
    @Override
    public String render() {
        return "\t";
    }
}

// Document class responsible for concatenating the render output of all the elements.
class Document {
    private List<DocumentElement> documentElements = new ArrayList<> ();

    public void addElement(DocumentElement element) {
        documentElements.add(element);
    }

    public String render() {
        String result = "";
        for(DocumentElement element: documentElements) 
            result += element.render();

        return result;
    }
}

interface Persistence {
    public void save(String str);
}

class SaveToDB implements Persistence {
    @Override
    public void save(String str) {
        System.out.println("Saving to Database");
    }
}

class SaveToFile implements Persistence {
    @Override
    public void save(String str) {
        System.out.println("Saving to File");
    }
}

class DocumentEditor {
    Document doc;
    Persistence db;
    String renderedDocument = new String();

    public DocumentEditor(Document doc, Persistence db) {
        this.doc = doc;
        this.db = db;
    }

    public void addText(String text) {
        doc.addElement(new TextElement(text));
    }

    public void addImage(String imagePath) {
        doc.addElement(new ImageElement(imagePath));
    }

    public void addNewLine() {
        doc.addElement(new NewLineElement());
    }

    public void addTabLine() {
        doc.addElement(new TabSpaceElement());
    }

    public String renderDocument() {
        if(renderedDocument.isEmpty()) 
            renderedDocument = doc.render();

        return renderedDocument;
    }

    public void saveDocument() {
        db.save(renderedDocument);
    }
}