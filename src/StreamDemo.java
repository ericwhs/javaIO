import java.io.*;

/**
 * Created by 80072415 on 2015-09-01.
 */
public class StreamDemo {
    private static final String SOURCE_PATH = "D:\\test_pic.png";
    private static final String DEST_PATH = "F:\\test_pic_dest.png";

    public static void main(String[] args){
        beautifulCopyByStream();
    }

    public static void beautifulCopyByStream(){
        BufferedInputStream bufIs = null;
        BufferedOutputStream bufOs = null;

        try {
            bufIs = new BufferedInputStream(new FileInputStream(SOURCE_PATH));
            bufOs = new BufferedOutputStream(new FileOutputStream(DEST_PATH));

            int len = 0;
            byte[] buf = new byte[1024];
            while ((len = bufIs.read(buf)) != -1){
                bufOs.write(buf,0,len);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            closeInput(bufIs);
            colseOutput(bufOs);
        }
    }

    public static void copyByStream(){

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(SOURCE_PATH);
            fos = new FileOutputStream(DEST_PATH);

            int len = 0;
            byte[] buf = new byte[1024];
            while((len = fis.read(buf)) != -1){
                fos.write(buf,0,len);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeInput(fis);
            colseOutput(fos);
        }
    }

    public static void closeInput(InputStream is){
        if (is != null){
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void colseOutput(OutputStream os){
        if (os != null){
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
