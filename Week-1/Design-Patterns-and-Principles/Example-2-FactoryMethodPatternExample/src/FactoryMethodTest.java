public class FactoryMethodTest {
    public static void main(String[] args) {
        DocumentFactory[] factories = {
            new WordDocumentFactory(),
            new PdfDocumentFactory(),
            new ExcelDocumentFactory()
        };

        for (DocumentFactory factory : factories) {
            Document document = factory.createDocument();
            System.out.println("Created: " + document.getClass().getSimpleName());
            document.open();
        }
    }
}
