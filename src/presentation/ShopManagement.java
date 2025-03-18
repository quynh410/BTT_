package presentation;

import entity.Categories;
import entity.Product;
import java.util.Scanner;

public class ShopManagement {
    static Categories[] arrCategory = new Categories[300];
    static Product[] arrProduct = new Product[300];
    static int currentIndex = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("*********************SHOP MENU*********************");
            System.out.println("1. Quản lý danh mục");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn (1 - 3): ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    boolean isExit = true;
                    do {
                        System.out.println("********************CATEGORIE MANAGEMENT*********************");
                        System.out.println("1. Danh sách danh mục");
                        System.out.println("2. Thêm mới danh mục");
                        System.out.println("3. Cập nhật danh mục");
                        System.out.println("4. Xóa danh mục");
                        System.out.println("5. Tìm kiếm danh mục theo tên");
                        System.out.println("6. Thoát");
                        System.out.print("Lựa chọn (1 - 6): ");
                        int choiceCategory = Integer.parseInt(scanner.nextLine());
                        switch (choiceCategory) {
                            case 1:
                                System.out.println("Danh sách danh mục ");
                                displayListCategory();
                                break;
                            case 2:
                                addCategory(scanner);
                                break;
                            case 3:
                                updateCategory(scanner);
                                break;
                            case 4:
                                deleteCategory(scanner);
                                break;
                            case 5:
                                searchCategoryByName(scanner);
                                break;
                            case 6:
                                isExit = false;
                                break;
                            default:
                                System.err.println("Vui lòng chọn (1 - 6)");
                        }
                    }while (isExit);
                    break;
                case 2:
                    boolean isCheck = true;
                    do {
                        System.out.println("************************PRODUCT MANAGEMENT*******************");
                        System.out.println("1. Danh sách sản phẩm");
                        System.out.println("2. Thêm mới sản phẩm");
                        System.out.println("3. Cập nhật sản phẩm");
                        System.out.println("4. Xóa sản phẩm");
                        System.out.println("5. Tìm kiếm sản phẩm theo tên hoặc tiêu đề");
                        System.out.println("6. Tìm kiếm sản phẩm theo khoảng giá bán");
                        System.out.println("7. Sắp xếp sản phẩm theo giá bán tăng dần");
                        System.out.println("8. Bán sản phẩm");
                        System.out.println("9. Thống kê số lượng sản phẩm theo danh mục");
                        System.out.println("10. Thoát");
                        System.out.print("Lựa chọn (1 - 10): ");
                        int choiceProduct = Integer.parseInt(scanner.nextLine());
                        switch (choiceProduct) {
                            case 1:
                                System.out.println("Danh sách sản phẩm");
                                displayListProduct();
                                break;
                            case 2:
                                addProduct(scanner);
                                break;
                            case 3:
                                updateProduct(scanner);
                                break;
                            case 4:
                                deleteProduct(scanner);
                                break;
                            case 5:
                                searchProductByName(scanner);
                                break;
                            case 6:
                                searchProductByPrice(scanner);
                                break;
                            case 7:
                                sortProductByPrice();
                                break;
                            case 8:
                                sellProduct(scanner);
                                break;
                            case 9:
                                productStatistic();
                                break;
                            case 10:
                                isCheck = false;
                            default:
                                System.err.println("Vui lòng chọn (1 - 10)");
                        }
                    }while (isCheck);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn (1 - 3)");
            }
        }while (true);
    }

    //    Hiển thị danh sách danh mục
    public static void displayListCategory() {
        for (int i = 0; i < currentIndex; i++) {
            arrCategory[i].displayData();
        }
    }

    //    Thêm mới danh mục
    public static void addCategory(Scanner scanner) {
        System.out.print("Nhập số danh mục cần thêm mới: ");
        int numberOfCategories = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfCategories; i++) {
            arrCategory[i] = new Categories();
            arrCategory[currentIndex].inputData(scanner);
            currentIndex++;
        }
    }

    //    Cập nhật danh mục
    public static void updateCategory(Scanner scanner) {
        System.out.print("Nhập vào mã danh mục cần cập nhật: ");
        int categoriId = Integer.parseInt(scanner.nextLine());
        int indexUpdate = findCategoryById(categoriId);
        if (indexUpdate == -1) {
            System.err.printf("Không tìm thấy danh mục có mã %d",categoriId);
        }else {
            boolean isCategoryUpdate = true;
            do {
                System.out.println("1. Cập nhật mã danh mục");
                System.out.println("2. Cập nhật tên danh mục");
                System.out.println("3. Cập nhật độ ưu tiên");
                System.out.println("4. Cập nhật mô tả danh mục");
                System.out.println("5. Cập nhật trạng thái danh mục");
                System.out.println("6. Thoát");
                System.out.println("Lựa chọn (1 - 6): ");
                int choiceCategoryUpdate = Integer.parseInt(scanner.nextLine());
                switch (choiceCategoryUpdate) {
                    case 1:
                        System.out.print("Nhập vào mã danh mục cần cập nhật: ");
                        arrCategory[indexUpdate].setCategoriId(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 2:
                        System.out.print("Nhập vào tên danh mục cần cập nhật: ");
                        arrCategory[indexUpdate].setCategoriName(scanner.nextLine());
                        break;
                    case 3:
                        System.out.println("Nhập vào độ ưu tiên cần cập nhật: ");
                        arrCategory[indexUpdate].setCategoriPriority(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 4:
                        System.out.print("Nhập vào mô tả danh mục cần cập nhật: ");
                        arrCategory[indexUpdate].setCategoriDescription(scanner.nextLine());
                        break;
                    case 5:
                        System.out.println("Nhập vào trang thái danh mục cần cập nhật: ");
                        arrCategory[indexUpdate].setCategoriActive(Boolean.parseBoolean(scanner.nextLine()));
                        break;
                    case 6:
                        isCategoryUpdate = false;
                        break;
                    default:
                        System.err.println("Vui lòng chọn từ (1 - 6)");
                }
            }while (isCategoryUpdate);
        }
    }

    //    Lấy ra ID của danh mục
    public static int findCategoryById(int categoriId) {
        for (int i = 0; i < currentIndex; i++) {
            if (arrCategory[i].getCategoriId() == categoriId) {
                return i;
            }
        }
        return -1;
    }

    //    Xóa danh mục sản phẩm
    public static void deleteCategory(Scanner scanner) {
        System.out.print("Nhập vào mã danh mục cần xóa: ");
        int categoriId = Integer.parseInt(scanner.nextLine());

        if (categoryHasProducts(categoriId)) {
            System.err.println("Không thể xóa! Danh mục vẫn còn sản phẩm.");
            return;
        }

        int indexDelete = findCategoryById(categoriId);
        if (indexDelete == -1) {
            System.err.println("Ko tồn tại danh mục có mã: " + categoriId);
        } else {
            for (int i = indexDelete; i < currentIndex; i++) {
                arrCategory[i] = arrCategory[i + 1];
            }
            currentIndex--;
            System.out.println("Danh mục có mã " + categoriId + " đã được xóa.");
        }
    }

    //     Kiểm tra danh mục có sản phẩm không
    public static boolean categoryHasProducts(int categoryId) {
        for (Categories category : arrCategory) {
            if (category.getCategoriId() == categoryId) return true;
        }
        return false;
    }

    //    Tìm kiếm danh mục theo tên
    public static void searchCategoryByName(Scanner scanner) {
        System.out.print("Nhập tên danh mục: ");
        String searchName = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < arrCategory.length; i++) {
            if (arrCategory[i] != null && arrCategory[i].getCategoriName().equals(searchName)) {
                arrCategory[i].displayData();
                found = true;
            }
        }
        if (!found) {
            System.err.println("Không tìm thấy danh mục.");
        }

    }

    // Hiển thị danh sách sản phẩm
    public static void displayListProduct() {
        for (int i = 0; i < currentIndex; i++) {
            arrProduct[i].displayData();
        }
    }

    //    Thêm mới sản phẩm
    public static void addProduct(Scanner scanner) {
        System.out.print("Nhập số lượng sản phẩm cần thêm: ");
        int numberOfProducts = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfProducts; i++) {
            arrProduct[currentIndex] = new Product();
            arrProduct[currentIndex].inputData(scanner);
            currentIndex++;
        }
    }
    //    Cập nhật sản phẩm
    public static void updateProduct(Scanner scanner) {
        System.out.print("Nhập vào mã sản phẩm cần cập nhật: ");
        String productId = scanner.nextLine();
        int indexProductUpdate = findProductById(productId);
        if (indexProductUpdate == -1) {
            System.err.printf("Ko tìm thấy sản phẩm có mã %d",productId);
        } else {
            boolean isUpdateProduct = true;
            do {
                System.out.println("1. Cập nhật mã sản phẩm");
                System.out.println("2. Cập nhật tên sản phẩm");
                System.out.println("3. Cập nhật giá nhập sản phẩm");
                System.out.println("4. Cập nhật giá xuất sản phẩm");
                System.out.println("5. Cập nhật tiêu đề sản phẩm");
                System.out.println("6. Cập nhật mô tả sản phẩm");
                System.out.println("7. Cập nhật số lượng sản phẩm");
                System.out.println("8. Cập nhật mã danh mục sản phẩm");
                System.out.println("9. Cập nhật trạng thái sản phẩm");
                System.out.println("Lựa chọn (1 - 9): ");
                int choiceUpdateProduct = Integer.parseInt(scanner.nextLine());
                switch (choiceUpdateProduct) {
                    case 1:
                        System.out.print("Nhập vào mã sản phẩm cần cập nhật: ");
                        arrProduct[indexProductUpdate].setProductId(scanner.nextLine());
                        break;
                    case 2:
                        System.out.print("Nhập vào tên sản phẩm cần cập nhật: ");
                        arrProduct[indexProductUpdate].setProductName(scanner.nextLine());
                        break;
                    case 3:
                        System.out.print("Nhập vào giá nhập sản phẩm: ");
                        arrProduct[indexProductUpdate].setProductImportPrice(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 4:
                        System.out.print("Nhập vào giá xuất sản phẩm: ");
                        arrProduct[indexProductUpdate].setProductExportPrice(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 5:
                        System.out.print("Nhập vào mô tả sản phẩm: ");
                        arrProduct[indexProductUpdate].setProductDescription(scanner.nextLine());
                        break;
                    case 6:
                        System.out.print("Nhập vào số lượng sản phẩm: ");
                        arrProduct[indexProductUpdate].setProductQuantity(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 7:
                        System.out.print("Nhập vào mã danh mục sản phẩm: ");
                        arrProduct[indexProductUpdate].setCategoryId(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 8:
                        System.out.print("Nhập vào trạng thái sản phẩm: ");
                        arrProduct[indexProductUpdate].setProductStatus(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 9:
                        isUpdateProduct = false;
                        break;
                    default:
                        System.err.println("Vui lòng nhập (1 - 9)");
                }
            }while (isUpdateProduct);
        }
    }
    //Lấy id của sản phẩm
    public static int findProductById(String productId) {
        for (int i = 0; i < currentIndex; i++) {
            if (arrProduct[i].getProductId().equals(productId)) {
                return i;
            }
        }
        return -1;
    }

    //    Xóa sản phẩm
    public static void deleteProduct(Scanner scanner) {
        System.out.print("Nhập vào mã sản phẩm cần xóa: ");
        String productId = scanner.nextLine();

        int indexDeleteProduct = findProductById(productId);
        if (indexDeleteProduct == -1) {
            System.err.println("Ko tồn tại sản phẩm có mã " +productId);
        } else {
            for (int i = indexDeleteProduct; i < currentIndex; i++) {
                arrProduct[i] = arrProduct[i + 1];
            }
            currentIndex--;
        }
    }

    //    Tìm kiếm sản phẩm theo tên hoặc tiêu đề
    public static void  searchProductByName(Scanner scanner) {
        System.out.print("Nhập tên sản phẩm: ");
        String searchproductName = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < currentIndex; i++) {
            if (arrProduct[i] != null && arrProduct[i].getProductName().equals(searchproductName)) {
                arrProduct[i].displayData();
                found = true;
            }
        }
        if (!found) {
            System.err.println("Ko tìm thấy tên sản phẩm");
        }

    }
    //    Tìm kiếm sản phẩm theo khoảng giá bán
    public static void searchProductByPrice(Scanner scanner) {
        System.out.print("Nhập giá bán thấp nhất: ");
        int priceMin = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập giá bán cao nhất: ");
        int priceMax = Integer.parseInt(scanner.nextLine());
        boolean found = false;
        for (int i = 0; i < currentIndex; i++) {
            if (arrProduct[i] != null && arrProduct[i].getProductExportPrice() >= priceMin && arrProduct[i].getProductExportPrice() <= priceMax) {
                arrProduct[i].displayData();
                found = true;
            }
        }

        if (!found) {
            System.err.println("Không tìm thấy sản phẩm nào trong khoảng giá.");
        }

    }
    //    Sắp xếp sản phẩm theo giá bán tăng dần
    public static  void sortProductByPrice() {
        for (int i = 0; i < currentIndex - 1; i++) {
            for (int j = 0; j < currentIndex - i - 1; j++) {
                if (arrProduct[j] != null && arrProduct[j + 1] != null && arrProduct[j].getProductExportPrice() > arrProduct[j + 1].getProductExportPrice()) {
                    Product temp = arrProduct[j];
                    arrProduct[j] = arrProduct[j + 1];
                    arrProduct[j + 1] = temp;
                }
            }
        }

        System.out.println("Danh sách sản phẩm sau khi được sắp xếp theo giá tăng dần: ");
        for (int i = 0; i < currentIndex; i++) {
            arrProduct[i].displayData();
        }
    }
    //    Bán sản phẩm
    public static  void sellProduct(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm cần bán: ");
        String productId = scanner.nextLine();
        int index = findProductById(productId);
        if (index == -1) {
            System.err.println("Ko tìm thấy sản phẩm có mã: " + productId);
        }
        Product product = arrProduct[index];
        if (product.getProductQuantity() <= 0) {
            System.err.println("Sản phẩm đã hết hàng, không thể bán!");
        }
        System.out.print("Nhập số lượng muốn bán: ");
        int sellQuantity = Integer.parseInt(scanner.nextLine());

        if (sellQuantity > product.getProductQuantity()) {
            System.err.println("Số lượng trong kho không đủ! Số lượng hiện tại: " + product.getProductQuantity());
        }

        product.setProductQuantity(product.getProductQuantity() - sellQuantity);
        System.out.println("Bán thành công " + sellQuantity + " sản phẩm. Số lượng còn lại: " + product.getProductQuantity());
    }
    //    Thống kê số lượng sản phẩm theo danh mục
    public static  void productStatistic() {
        System.out.println("Thống kê số lượng sản phẩm theo danh mục:");
        for (int i = 0; i < currentIndex; i++) {
            int categoryId = arrProduct[i].getCategoryId();
            int totalQuantity = 0;

            for (int j = 0; j < currentIndex; j++) {
                if (arrProduct[j].getCategoryId() == categoryId) {
                    totalQuantity += arrProduct[j].getProductQuantity();
                }
            }
            System.out.println("Danh mục ID: " + categoryId + " - Số lượng: " + totalQuantity);
        }
    }
}
