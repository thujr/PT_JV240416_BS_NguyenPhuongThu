package ra.run;

import ra.entity.Laptop;
import ra.entity.LaptopType;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.jar.JarOutputStream;

public class Main {
    public static List<LaptopType> listLaptopType = new ArrayList<>();
    public static List<Laptop> listLaptop = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("********LAPTOP-MANAGEMENT**********");
            System.out.println("1.Quản lý loại laptop.");
            System.out.println("2.Quản lý laptop");
            System.out.println("3.Thoát");
            System.out.printf("Lựa chọn của bạn:");
            int choice = inputChoiceMenu(scanner.nextLine());
            switch (choice) {
                case 1:
                    inputLaptopTypeMenu(scanner);
                    break;
                case 2:
                    inputLaptopMenu(scanner);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng nhập từ 1-3.");
            }

        } while (true);
    }

    public static void inputLaptopTypeMenu(Scanner scanner) {
        boolean flag = true;
        do {
            System.out.println("******LAPTOP_TYPE_MENU*******");
            System.out.println("1.Hiển thị danh sách các loại laptop.");
            System.out.println("2.Thêm mới loai laptop.");
            System.out.println("3.Cập nhật thông tin loại laptop.");
            System.out.println("4.Xóa loai laptop.");
            System.out.println("5.Thoát");
            System.out.println("Lựa chọn của bạn");
            int choice = inputChoiceMenu(scanner.nextLine());
            switch (choice) {
                case 1:
                    displayListLaptopType(scanner);
                    break;
                case 2:
                    addNewLaptopType(scanner);
                    break;
                case 3:
                    updateLaptopType(scanner);
                    break;
                case 4:
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    System.err.println("Vui lòng nhập từ 1-5");
            }

        } while (flag);
    }

    public static void displayListLaptopType(Scanner scanner) {
        for (LaptopType laptopType : listLaptopType) {
            if (!laptopType.isDeleted()) {
                laptopType.displayData(scanner);
            }
        }
    }

    public static void addNewLaptopType(Scanner scanner) {
        LaptopType laptopType = new LaptopType();
        laptopType.inputData(scanner);
        listLaptopType.add(laptopType);
        System.out.println("Đã thêm thể loại laptop thành công.");
    }

    public static void updateLaptopType(Scanner scanner) {
        System.out.println("Nhập mã laptop cần cập nhật.");
        int updateId = Integer.parseInt(scanner.nextLine());
        int indexId = getIndexById(updateId);
        if (indexId >= 0) {
            boolean flag = true;
            do {
                System.out.println("1.Cập nhật tên thể loại");
                System.out.println("2.Cập nhật mô tả thể loại.");
                System.out.println("3.Thoát.");
                System.out.println("4.Lựa chọn của bạn.");
                int choice = inputChoiceMenu(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Cập nhật tên loại laptop mới:");
                        listLaptopType.get(indexId).setTypeName(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Cập nhật mô tả cho loai laptop");
                        listLaptopType.get(indexId).setDescription(scanner.nextLine());
                    case 3:
                        flag = false;
                        break;
                    default:
                        System.err.println("Vui lòng nhập từ 1-3");
                }
            } while (flag);
        } else {
            System.err.println("Mã thể loại không tồn tại");
        }
    }

    public static void deleteLaptopType(Scanner scanner) {
        System.out.println("Nhập mã loại laptop muốn xóa");
        int idDelete = Integer.parseInt(scanner.nextLine());
        int indexDelete = getIndexById(idDelete);
        if (indexDelete >= 0) {

        } else {
            System.err.println("Mã loại laptop không tồn tại.");
        }
    }

    public static int getIndexById(int id) {
        for (int i = 0; i < listLaptopType.size(); i++) {
            if (listLaptopType.get(i).getTypeId() == id) {
                return i;
            }
        }
        return -1;
    }


    public static void inputLaptopMenu(Scanner scanner) {
        boolean flag = true;
        do {
            System.out.println("*************LAPTOP_MENU**********");
            System.out.println("1.Danh sách laptop.");
            System.out.println("2.Thêm mới laptop.");
            System.out.println("3.Cập nhật thông tin laptop.");
            System.out.println("4.Xóa laptop");
            System.out.println("5.Thống kê số lượng laptop theo từng loại.");
            System.out.println("6.Thoát");
            System.out.println("Lựa chọn của bạn:");
            int choice = inputChoiceMenu(scanner.nextLine());
            switch (choice) {
                case 1:
                    displayListLaptop(scanner);
                    break;
                case 2:
                    addNewLaptop(scanner);
                    break;
                case 3:
                    updateLaptop(scanner);
                    break;
                case 4:
                    deleteLaptop(scanner);
                    break;
                case 5:
                    break;
                case 6:
                    displayLaptopLaptopType(scanner);
                    flag = false;
                    break;
                default:
                    System.err.println("Vui lòng nhập từ 1-6");
            }

        } while (flag);
    }

    public static void displayListLaptop(Scanner scanner) {
        for (Laptop laptop : listLaptop) {
            if (!laptop.isDeleted()) {
                laptop.displayData(scanner);
            }
        }
    }

    public static void addNewLaptop(Scanner scanner) {
        Laptop laptop = new Laptop();
        laptop.inputData(scanner);
        listLaptop.add(laptop);
        System.out.println("Đã thêm laptop thành công.");
    }

    public static void updateLaptop(Scanner scanner) {
        System.out.println("Nhập mã laptop cần cập nhật.");
        String idLaptop = scanner.nextLine();
        int indexIdLaptop = getIndexByIdLaptop(idLaptop);
        if (indexIdLaptop > 0) {
            boolean flag = true;
            do {
                System.out.println("1.Cập nhật tên laptop.");
                System.out.println("2.Cập nhật mô tả lap top");
                System.out.println("3.Cập nhật bộ nhớ máy.");
                System.out.println("4.Cập nhật cân nặng máy.");
                System.out.println("5.Câpj nhật giá máy.");
                System.out.println("6.Thoát");
                System.out.println("Lựa chọn của bạn:");
                int choice = inputChoiceMenu(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Cập nhật tên laptop:");
                        listLaptop.get(indexIdLaptop).setLaptopName(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Cập nhật mô tả laptop:");
                        listLaptop.get(indexIdLaptop).setDescription(scanner.nextLine());
                        break;
                    case 3:
                        System.out.println("Cập nhật bộ nhớ máy:");
                        listLaptop.get(indexIdLaptop).setRam(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 4:
                        System.out.println("Cập nhật cân nặng máy.");
                        listLaptop.get(indexIdLaptop).setWeight(Double.parseDouble(scanner.nextLine()));
                        break;
                    case 5:
                        System.out.println("Cập nhật giá máy:");
                        listLaptop.get(indexIdLaptop).setLaptopPrice(Double.parseDouble(scanner.nextLine()));
                    case 6:
                        flag = false;
                        break;
                    default:
                        System.err.println("Vui lòng nhập từ 1-5");
                }
            } while (flag);
        } else {
            System.err.println("Mã laptop không tồn tại. Vui lòng nhập lại.");
        }

    }

    public static int getIndexByIdLaptop(String id) {
        for (int i = 0; i < listLaptop.size(); i++) {
            if (listLaptop.get(i).getLaptopId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public static void deleteLaptop(Scanner scanner) {
        System.out.println("Nhập mã laptop muôns xóa");
        String idDeleteLaptop = scanner.nextLine();
        int indexDelete = getIndexById(Integer.parseInt(idDeleteLaptop));
        if (indexDelete >= 0) {
            listLaptop.remove(indexDelete);
            System.out.println("Đã xóa laptop thành công.");
        } else {
            System.err.println("Mã laptop không tồn tại.Vui lòng nhập lại.");
        }
    }

    public static int inputChoiceMenu(String choiceStr) {
        do {
            try {
                int choice = Integer.parseInt(choiceStr);
                return choice;
            } catch (Exception ec) {
                System.err.println("Lỗi:" + ec.getMessage());
            }
        } while (true);
    }

    public static void displayLaptopLaptopType(Scanner scanner) {
        for (LaptopType laptopType : listLaptopType) {
            System.out.printf("%s_ %d laptop\n", laptopType.getTypeName(),
                    listLaptop.stream().filter(laptop -> laptop.getTypeId() == laptopType.getTypeId()).count());

        }
    }
}

