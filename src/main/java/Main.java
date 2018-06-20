public class Main {
    public static void main(String[] args) {

        String sourcePath = "file or folder sopurce path";
        String destinationZipFile = "destination path for zip file";
        String destinationPath = "destination path for unzipped file";

        ZipUtils zipUtils = new ZipUtils();
        try {
            zipUtils.zip(sourcePath, destinationZipFile);
            zipUtils.unzip(destinationZipFile, destinationPath);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
