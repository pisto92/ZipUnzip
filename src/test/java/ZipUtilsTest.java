import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

import static org.junit.Assert.assertTrue;

public class ZipUtilsTest {

    private static final String TEST_RESOURCE_PATH = "src/test/res/ziputils/";
    private static final String OUTPUT_PATH = TEST_RESOURCE_PATH + "output/";
    private ZipUtils zipUtils;

    @Before
    public void setUp() {
        zipUtils = new ZipUtils();
        new File(OUTPUT_PATH).mkdir();
    }

    @After
    public void tearDown() throws Exception {
        Files.walk(Paths.get(OUTPUT_PATH))
                .sorted(Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(File::delete);
    }

    private void checkFileExists(String path) {
        assertTrue(new File(path).exists());
    }

    @Test
    public void testZipFile() throws Exception {
        String sourceFilePath = TEST_RESOURCE_PATH + "testFile.txt";
        String zipFilePath = OUTPUT_PATH + "testFile.zip";

        zipUtils.zip(sourceFilePath, zipFilePath);

        checkFileExists(zipFilePath);
    }

    @Test
    public void testZipDirectory() throws Exception {
        String sourceFolderPath = TEST_RESOURCE_PATH + "testFolder/";
        String zipFolderPath = OUTPUT_PATH + "testFolder.zip";

        zipUtils.zip(sourceFolderPath, zipFolderPath);

        checkFileExists(zipFolderPath);
    }

    @Test
    public void testUnzipFile() throws Exception {
        String zipFilePath = TEST_RESOURCE_PATH + "testZippedFile.zip";

        zipUtils.unzip(zipFilePath, OUTPUT_PATH);

        checkFileExists(OUTPUT_PATH + "/file.txt");
    }

    @Test
    public void testUnzipDirectoryWithFiles() throws Exception {
        String zipFolderPath = TEST_RESOURCE_PATH + "testZippedFolder.zip";

        zipUtils.unzip(zipFolderPath, OUTPUT_PATH);

        checkFileExists(OUTPUT_PATH + "/testFolder");
        checkFileExists(OUTPUT_PATH + "/testFolder/content.txt");
    }
}
