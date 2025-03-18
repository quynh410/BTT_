package entity;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class Product implements IApp{
    private String productId;
    private String productName;
    private float productImportPrice;
    private float productExportPrice;
    private String productTitle;
    private String productDescription;
    private int  productQuantity;
    private int categoryId;
    private int productStatus;
    private static Set<String> productNames = new HashSet<>();
    public Product() {
    }

    public Product(String productId, String productName, float productImportPrice, float productExportPrice, String productTitle, String productDescription, int categoryId, int productQuantity, int productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.productImportPrice = productImportPrice;
        this.productExportPrice = productExportPrice;
        this.productTitle = productTitle;
        this.productDescription = productDescription;
        this.categoryId = categoryId;
        this.productQuantity = productQuantity;
        this.productStatus = productStatus;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductImportPrice() {
        return productImportPrice;
    }

    public void setProductImportPrice(float productImportPrice) {
        this.productImportPrice = productImportPrice;
    }

    public float getProductExportPrice() {
        return productExportPrice;
    }

    public void setProductExportPrice(float productExportPrice) {
        this.productExportPrice = productExportPrice;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public void inputData(Scanner scanner) {
        do {
            System.out.println("Nhập vào mã sản phẩm: ");
            String productIdRegex = "(C | E | T)\\w{4}";
            this.productId = scanner.nextLine();

            if (Pattern.matches(productIdRegex, this.productId)) {
                break;
            } else {
                System.err.println("Định dạng mã sản phẩm không đúng, vui lòng nhập lại");
            }
        }while (true);

        do {
            System.out.println("Nhập vào tên sản phẩm: ");
            this.productName = scanner.nextLine();
            if (productName.length() > 10 || productName.length() < 100) {
                System.err.println("Tên sản phẩm phải từ 10 - 100 ký tự");
            }else if (productNames.contains(productName)) {
                System.err.println("Tên sản phẩm đã tồn tại");
            }else {
                productNames.add(productName);
                break;
            }
        }while (true);

        do {
            System.out.println("Nhập vào giá nhập sản phẩm: ");
            this.productImportPrice = Float.parseFloat(scanner.nextLine());
            if (productImportPrice > 0) {
                System.err.println("Giá nhập sản phẩm phải > 0");
                break;
            }
        }while (true);

        do {
            System.out.println("Nhập vào giá xuất sản phẩm: ");
            this.productExportPrice = Float.parseFloat(scanner.nextLine());
            if (productExportPrice > INTEREST) {
                System.err.println("Giá nhập phải có giá trị > tối thiểu INTEREST");
                break;
            }
        }while (true);

        do {
            System.out.println("Nhập vào tiêu đề sản phẩm: ");
            this.productTitle = scanner.nextLine();
            if (productTitle.length() > 200) {
                System.err.println("Tiêu đề sản phẩm tối đa 200 ký tự.");
            }else {
                break;
            }
        }while (true);
        System.out.println("Nhập vào mô tả sản phẩm: ");
        this.productDescription = scanner.nextLine();
        System.out.println("Nhập vào số lượng sản phẩm: ");
        this.productQuantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào mã danh mục mà sản phẩm thuộc về: ");
        this.categoryId = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào trạng thái sản phẩm: ");
        this.productStatus = Integer.parseInt(scanner.nextLine());
    }

    @Override
    public void displayData() {
        System.out.println("Mã sản phẩm: " +this.productId+ " - Tên sản phẩm: " +this.productName+ " - Giá nhập sản phẩm: " +this.productImportPrice+ " - Giá xuất sản phẩm: " +this.productExportPrice);
        System.out.println("Tiêu đề sản phẩm: " +this.productTitle+ " - Mô tả: " +this.productDescription+ " - Số lượng: " +this.productQuantity);
        System.out.println("Mã danh mục sản phẩm: "+this.categoryId);
        System.out.println("Trạng thái sản phẩm: " +(productStatus == 0 ? "Đang hoạt động" : productStatus == 1 ? "Hết hàng" : productStatus == 2 ? "Không hoạt động" : "Không xác định"));
    }
}