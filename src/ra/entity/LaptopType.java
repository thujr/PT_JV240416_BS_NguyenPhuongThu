package ra.entity;

import ra.run.Main;

import java.util.Comparator;
import java.util.Scanner;

public class LaptopType {
    private int typeId;
    private String typeName;
    private String description;
    private String bookId;
    private boolean isDeleted;

    public LaptopType() {
    }

    public LaptopType(int typeId, String typeName, String description, String bookId, boolean isDeleted) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.description = description;
        this.bookId = bookId;
        this.isDeleted = isDeleted;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public void inputData(Scanner scanner) {
        this.typeId=inputTypeId(scanner);
        this.typeName=inputTypeName(scanner);
        this.description=inputDescription(scanner);
        this.isDeleted=inputStatus(scanner);

    }

    public void displayData(Scanner scanner){
        System.out.printf("Mã loại laptop: %d_ Tên loai laptop: %s_ Mô tả loai laptop: %s_ Trạng thái loại laptop: %s\n",
                this.typeId,this.typeName,this.description,this.isDeleted?"Còn hàng":"Hết hàng");
    }

    public static int inputTypeId(Scanner scanner) {
        for (int i = 0; i < Main.listLaptopType.size(); i++)
            if (Main.listLaptopType.isEmpty()) {
                return 1;
            }
        int idMax = Main.listLaptopType.stream().max(Comparator.comparing(LaptopType::getTypeId)).get().getTypeId();
        return idMax + 1;
    }

    public static String inputTypeName(Scanner scanner){
        System.out.println("Nhập tên loại Laptop");
        do {
            String typeName=scanner.nextLine();
            if (typeName.trim().isEmpty()){
                System.err.println("Tên loại laptop không được để trống.");
            }else{
                boolean isExit=Main.listLaptopType.stream().anyMatch(laptopType -> laptopType.getTypeName().equals(typeName));
                if (isExit){
                    System.err.println("Tên loại Lap top đã tồn tại. Vui lòng nhập lại.");
                }else{
                    return typeName;
                }
            }
        }while(true);
    }

    public static String inputDescription(Scanner scanner){
        System.out.println("Nhập mô tả thể loại vào đây.");
        do {
            String description=scanner.nextLine();
            if (description.trim().isEmpty()){
                System.err.println("Mô tả danh mục không được để trông");
            }else{
                return description;
            }

        }while(true);
    }

    public static boolean    inputStatus(Scanner scanner){
        System.out.println("Nhập trạng thái mã thể loại");
        do {
            String status=scanner.nextLine();
            if (status.equals("true")){
                return true;
            }else if(status.equals("false")){
                return false;
            }else{
                System.err.println("Trạng thái chỉ nhận gíá trị true||false");
            }

        }while(true);
    }
}

