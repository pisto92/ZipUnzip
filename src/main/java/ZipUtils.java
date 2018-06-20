import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;

import java.io.File;

class ZipUtils {

    void zip(String sourcePath, String pathZipFile) throws ZipException {
        try {
            ZipFile zipFile = new ZipFile(pathZipFile);
            File targetFile = new File(sourcePath);

            if (targetFile.isFile()) {
                zipFile.addFile(targetFile, new ZipParameters());
            } else if (targetFile.isDirectory()) {
                zipFile.addFolder(targetFile, new ZipParameters());
            }
        } catch (ZipException e) {
            throw new ZipException("Zip failed: " + e.getMessage());
        }

    }

    void unzip(String pathZipFile, String destinationPath) throws ZipException {
        try {
            ZipFile zipFile = new ZipFile(pathZipFile);
            zipFile.extractAll(destinationPath);

        } catch (ZipException e) {
            throw new ZipException("Unzip failed: " + e.getMessage());
        }
    }
}
