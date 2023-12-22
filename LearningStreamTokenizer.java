import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class LearningStreamTokenizer {
    public static void main(String[] args) throws IOException {
        FileReader fis = new FileReader("src/list_testcase.txt");
        BufferedReader br = new BufferedReader(fis);
        //DoubleLink list = new DoubleLink();
        //ShunxuArray list = new ShunxuArray();
        ResizingAList list = new ResizingAList();
        //SingleLink list = new SingleLink();

        PrintWriter pw = new PrintWriter("src/output.txt"); // ��������ļ���PrintWriterʵ��
        PrintWriter pw1 = new PrintWriter("src/out1.txt");
        PrintWriter pw2 = new PrintWriter("src/out2.txt");//�ռ�������д���������˴�ӡ
        String line;
        while ((line = br.readLine()) != null) {
            if (line.isEmpty()) {
                continue; // ��������
            }
            for (int i = 0; i < line.length(); i++) {
                char command = line.charAt(i);
                switch (command) {
                    case '+': {
                        try {
                            if (i < line.length() - 1) {
                                char val = line.charAt(i + 1);
                                list.insert(val);
                            }
                        } catch (ListException e) {
                            System.out.println("ERROR");
                        }
                        break;
                    }
                    case '-': {
                        list.remove();
                        break;
                    }
                    case '=': {
                        if (i < line.length() - 1) {
                            char val = line.charAt(i + 1);
                            list.replace(val);
                        }
                        break;
                    }
                    case '#': {
                        list.gotoBeginning();
                        break;
                    }
                    case '*': {
                        list.gotoEnd();
                        break;
                    }
                    case '>': {
                        list.gotoNext();
                        break;
                    }
                    case '<': {
                        list.gotoPrev();
                        break;
                    }
                    case '~': {
                        list.clear();
                        break;
                    }
                    default: {
                        break;
                    }
                }
            }

           // list.showStructure(pw2); // �����д�뵽�ļ���
            pw1.print(list.getRate());
            pw1.println(); // д�뻻�з�
            pw1.flush(); // ˢ�»�����
        }

        pw.close(); // �ر��ļ����

        br.close();
    }
}