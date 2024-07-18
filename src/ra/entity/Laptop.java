package ra.entity;

import ra.run.Main;

import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Laptop {
    private String laptopId;
    private String laptopName;
    private String description;
    private int ram;
    private double weight;
    private Date createAt;
    private double laptopPrice;
    private int typeId;
    private boolean isDeleted;

    public Laptop() {
    }

    public Laptop(String laptopId, String laptopName, String description, int ram, double weight, Date createAt, double laptopPrice, int typeId, boolean isDeleted) {
        this.laptopId = laptopId;
        this.laptopName = laptopName;
        this.description = description;
        this.ram = ram;
        this.weight = weight;
        this.createAt = createAt;
        this.laptopPrice = laptopPrice;
        this.typeId = typeId;
        this.isDeleted = isDeleted;
    }

    public String getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(String laptopId) {
        this.laptopId = laptopId;
    }

    public String getLaptopName() {
        return laptopName;
    }

    public void setLaptopName(String laptopName) {
        this.laptopName = laptopName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public double getLaptopPrice() {
        return laptopPrice;
    }

    public void setLaptopPrice(double laptopPrice) {
        this.laptopPrice = laptopPrice;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public void inputData(Scanner scanner) {
        this.laptopId = inputLaptopId(scanner);
        this.laptopName = inputLaptopName(scanner);
        this.description = inputDescription(scanner);
        this.ram = inputRam(scanner);
        this.weight = inputWeight(scanner);
        this.laptopPrice = inputLaptopPrice(scanner);
        this.typeId=inputTypeId(scanner);

    }

    public void displayData(Scanner scanner){
        System.out.printf("Mã laptop: %s_ Tên laptop: %s_ Mô tả laptop: %s_ Bộ nhớ máy: %d\n",
                this.laptopId,this.laptopName,this.description,this.ram);
        System.out.printf("Cân nặng laptop: %.2f_ Gía tiền laptop: %f_ Mã loại laptop: %d\n",
                this.weight,this.laptopPrice,this.typeId);
    }
    public static String inputLaptopId(Scanner scanner) {
        String laptopIdRegex = "L[0-9]{2,}";
        do {
            try {
                System.out.println("Nhập mã laptop:");
                String laptopId = scanner.nextLine();
                if (Pattern.matches(laptopIdRegex, laptopId)) {
                    boolean isExit = Main.listLaptop.stream().anyMatch(laptop -> laptop.getLaptopId().equals(laptop));
                    if (isExit) {
                        System.err.println("Mã laptop đã tồn tại.Vui lòng nhập lại");
                    } else {
                        return laptopId;
                    }
                } else {
                    System.err.println("Mã lap top không đúng định dạng");
                }
            } catch (Exception ec) {
                System.err.println("Lỗi: định dạng " + ec.getMessage());
            }
        } while (true);
    }

    public static String inputLaptopName(Scanner scanner) {
        System.out.println("Nhập tên laptop vào đây:");
        do {
            String laptopName = scanner.nextLine();
            if (laptopName.trim().isEmpty()) {
                System.err.println("Tên lapTop không được để trông.Vui lòng nhập lại");
            } else {
                boolean isExit = Main.listLaptop.stream().anyMatch(laptop -> laptop.getLaptopName().equals(laptopName));
                if (isExit) {
                    System.err.println("Tên laptop đã tồn tại.Vui lòng nhập lại.");
                } else {
                    return laptopName;
                }
            }

        } while (true);
    }

    public static String inputDescription(Scanner scanner) {
        System.out.println("Nhập mô tả laptop:");
        do {
            String description = scanner.nextLine();
            if (description.trim().isEmpty()) {
                System.err.println("Tên laptop không được để trống. Vui lòng nhập lại.");
            } else {
                return description;
            }
        } while (true);
    }

    public static int inputRam(Scanner scanner) {
        do {
            try {
                System.out.println("Nhập bộ nhớ laptop:");
                int ram = Integer.parseInt(scanner.nextLine());
                if (ram > 0) {
                    return ram;
                } else {
                    System.err.println("Bộ nhớ phải lớn hơn 0. Vui lòng nhập lại");
                }
            } catch (NumberFormatException nfe) {
                System.err.println("Lỗi: bộ nhớ là số nguyên lớn hơn 0.");
            }
        } while (true);
    }

    public static double inputWeight(Scanner scanner) {
        do {
            try {
                System.out.println("Nhập cân nặng máy.");
                double weight = Double.parseDouble(scanner.nextLine());
                if (weight > 0) {
                    return weight;
                } else {
                    System.err.println("Cân nặng laptop phải lớn hơn 0.");
                }
            } catch (NumberFormatException nef) {
                System.err.println("Cân nặng là số thực lớn hơn 0.");
            }
        } while (true);
    }

    public static double inputLaptopPrice(Scanner scanner) {
        do {
            try {
                System.out.println("Nhập giá tiền laotop:");
                double laptopPrice = Double.parseDouble(scanner.nextLine());
                if (laptopPrice > 0) {
                    return laptopPrice;
                } else {
                    System.err.println("Gía tiền laptop phải lớn hơn 0.Vui lòng nhập lại.");
                }

            } catch (NumberFormatException nfe) {
                System.err.println("Giá tiền phải là số thực lớn hơn 0.");
            }

        } while (true);
    }

    public static int inputTypeId(Scanner scanner) {
        System.out.println("Lựa chọn của bạn:");
        for (int i = 0; i < Main.listLaptopType.size(); i++) {
            System.out.printf("%d_ %s", Main.listLaptopType.get(i).getTypeName());
        }
        int choice = Integer.parseInt(scanner.nextLine());
        return Main.listLaptopType.get(choice - 1).getTypeId();
    }
}

