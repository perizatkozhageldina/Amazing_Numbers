class ManufacturingController {

    public static int requestNumber = 0;
    public static String requestProduct(String product) {
        requestNumber++;
        return requestNumber + ". Requested " + product;
    }

    public static int getNumberOfProducts() {
        return  requestNumber;
    }
}