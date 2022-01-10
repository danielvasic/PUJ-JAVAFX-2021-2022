package ba.sum.fsre.puj.pujjavafx20212022.model;

public class Article extends Table {
    @Entity(type="INTEGER", size=32, primary = true)
    int id;
    @Entity(type="VARCHAR", size=25)
    String name;
    @Entity(type="DECIMAL", size=10)
    float price;
    @Entity(type="VARCHAR", size=25)
    String code;
    @Entity(type="VARCHAR", size=255)
    String description;
    @Entity(type="VARCHAR", size=255)
    String image;
    @Entity(type="INTEGER", size=32)
    @ForeignKey(table = "Category", attribute = "id")
    int category_fk;
    @Entity(type="INTEGER", size=32)
    @ForeignKey(table = "Importer", attribute = "id")
    int importer_fk;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() throws Exception {
        return (Category) Table.get(Category.class, category_fk);
    }

    public void setCategory_fk(int category_fk) {
        this.category_fk = category_fk;
    }

    public Importer getImporter() throws Exception {
        return (Importer) Table.get(Importer.class, importer_fk);
    }

    public void setImporter_fk(int importer_fk) {
        this.importer_fk = importer_fk;
    }
}
