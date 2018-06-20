public class Main {
    public static void main(String[] args) {

        String sourcePath = "C:\\Users\\andre.pisto\\Desktop\\FolderPre";
        String destinationZipFile = "C:\\Users\\andre.pisto\\Desktop\\folderZipped.zip";
        String destinationPath = "C:\\Users\\andre.pisto\\Desktop\\unzipped";

        ZipUtils zipUtils = new ZipUtils();
        try {
            zipUtils.zip(sourcePath, destinationZipFile);
            zipUtils.unzip(destinationZipFile, destinationPath);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
