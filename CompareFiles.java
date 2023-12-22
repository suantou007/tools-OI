import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CompareFiles {
    public static void main(String[] args) throws IOException {
        String file1Path = "src/list_result.txt";
        String file2Path = "src/output.txt";

        boolean areFilesEqual = compareTextFiles(file1Path, file2Path);
        System.out.println("The files are " + (areFilesEqual ? "equal" : "not equal"));
    }

    private static boolean compareTextFiles(String file1Path, String file2Path) throws IOException {
        FileReader fileReader1 = new FileReader(file1Path);
        FileReader fileReader2 = new FileReader(file2Path);

        BufferedReader reader1 = new BufferedReader(fileReader1);
        BufferedReader reader2 = new BufferedReader(fileReader2);

        String line1;
        String line2=null;
        boolean areEqual = true;

        while ((line1 = reader1.readLine()) != null && (line2 = reader2.readLine()) != null) {
            if (!line1.equals(line2)) {
                areEqual = false;
                break;
            }
        }

        // 如果有一个文件已读完而另一个文件还有内容，则它们不相等
        if ((line1 == null && (line2 != null))|| (line1 != null && line2 == null)) {
            areEqual = false;
        }

        reader1.close();
        reader2.close();
        return areEqual;
    }
}