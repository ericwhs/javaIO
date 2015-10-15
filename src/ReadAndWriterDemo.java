import java.io.*;

public class ReadAndWriterDemo {

    public static void main(String[] args) {
        beautifullCopy();
    }

    /**
     * 未采用高效读取
     */
    public static void commonCopy(){
        FileReader fr = null;
        FileWriter fw = null;

        try {
            fr = new FileReader("D:\\aa.txt");
            fw = new FileWriter("F:\\bb.txt");

            int len = 0;
            while((len = fr.read()) != -1){
                fw.write(len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fr != null){
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (fw != null){
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void beautifullCopy(){
        BufferedReader bufr = null;
        BufferedWriter bufw = null;

        try {
            bufr = new BufferedReader(new FileReader("D:\\aa.txt"));
            bufw = new BufferedWriter(new FileWriter("F:\\cc.txt"));

            String content = null;
            while ((content = bufr.readLine()) != null){
                bufw.write(content);
                bufw.newLine();
                bufw.flush();//最后一行多出一个换行
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bufr != null){
                try {
                    bufr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bufw != null){
                try {
                    bufw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
