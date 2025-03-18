package entity;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Categories implements IApp{
    private static int autoIncrementId = 1;
    private int categoriId;
    private String categoriName;
    private int categoriPriority;
    private String categoriDescription;
    private boolean categoriActive;

    private static Set<String> categoryNames = new HashSet<>();

    public Categories() {
    }

    public Categories(int categoriId, String categoriName, int categoriPriority, String categoriDescription, boolean categoriActive) {
        this.categoriId = autoIncrementId++;
        this.categoriName = categoriName;
        this.categoriPriority = categoriPriority;
        this.categoriDescription = categoriDescription;
        this.categoriActive = categoriActive;
    }

    public int getCategoriId() {
        return categoriId;
    }

    public void setCategoriId(int categoriId) {
        this.categoriId = categoriId;
    }

    public String getCategoriName() {
        return categoriName;
    }

    public void setCategoriName(String categoriName) {
        this.categoriName = categoriName;
    }

    public int getCategoriPriority() {
        return categoriPriority;
    }

    public void setCategoriPriority(int categoriPriority) {
        this.categoriPriority = categoriPriority;
    }

    public String getCategoriDescription() {
        return categoriDescription;
    }

    public void setCategoriDescription(String categoriDescription) {
        this.categoriDescription = categoriDescription;
    }

    public boolean getCategoriActive() {
        return categoriActive;
    }

    public void setCategoriActive(boolean categoriActive) {
        this.categoriActive = categoriActive;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.print("Nhập vào mã danh mục : ");
        this.categoriId = Integer.parseInt(scanner.nextLine());
        do {
            System.out.print("Nhập vào tên danh mục : ");
            this.categoriName = scanner.nextLine().trim();

            if (categoriName.length() < 6 || categoriName.length() > 50) {
                System.err.println("Tên danh mục phải từ 6 - 50 ký tự.");
            } else if (categoryNames.contains(categoriName)) {
                System.err.println("Tên danh mục đã tồn tại. Vui lòng nhập lại.");
            } else {
                categoryNames.add(categoriName);
                break;
            }
        } while (true);


        System.out.print("Nhập vào độ ưu tiên : ");
        this.categoriPriority = Integer.parseInt(scanner.nextLine());

        do {
            System.out.print("Nhập vào mô tả danh mục : ");
            this.categoriDescription = scanner.nextLine();
            if (categoriDescription.length() > 255) {
                System.err.println("Mô tả danh mục tối đa 255 ký tự. Vui lòng nhập lại.");
            } else {
                break;
            }
        } while (true);
        System.out.print("Nhập vào trang thái danh mục : ");
        this.categoriActive = Boolean.parseBoolean(scanner.nextLine());
    }

    @Override
    public void displayData() {
        System.out.println("Mã danh mục: "+this.categoriId+ " - Tên danh mục: "+this.categoriName+ " Độ ưu tiên: "+this.categoriPriority);
        System.out.printf("Mô tả danh mục: %s - Trạng thái danh mục: %b", this.categoriActive == true ? "Hoạt động " : "Không hoạt động",this.categoriDescription);
    }
}