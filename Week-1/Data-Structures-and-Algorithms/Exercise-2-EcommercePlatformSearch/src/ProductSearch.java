public final class ProductSearch {
    private ProductSearch() {
    }

    public static Product linearSearch(Product[] products, int targetProductId) {
        for (Product product : products) {
            if (product.getProductId() == targetProductId) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] sortedProducts, int targetProductId) {
        int left = 0;
        int right = sortedProducts.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            Product middleProduct = sortedProducts[middle];

            if (middleProduct.getProductId() == targetProductId) {
                return middleProduct;
            }

            if (middleProduct.getProductId() < targetProductId) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return null;
    }
}
