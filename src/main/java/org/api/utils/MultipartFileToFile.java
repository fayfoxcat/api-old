package org.api.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Objects;

public class MultipartFileToFile {
    /**
     * MultipartFile 转 File
     * @param file
     * @throws Exception
     */
    public static File multipartFileToFile(MultipartFile file){
        File toFile = null;
        if (file != null && file.getSize() > 0) {
            InputStream ins;
            try {
                ins = file.getInputStream();
                toFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
                inputStreamToFile(ins, toFile);
                ins.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return toFile;
    }

    //获取流文件
    private static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除本地临时文件
     * @param file
     */
    public static void deleteTempFile(File file) {
        if (file != null) {
            File del = new File(file.toURI());
            del.delete();
        }
    }
}
