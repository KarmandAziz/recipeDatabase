package com.example.recipeDatabase.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IOManager {
    public void copy(File source, File destination) {

        try(InputStream in = new FileInputStream(source);
            OutputStream out = new FileOutputStream(destination)){

            int b;
            while((b = in.read()) != -1){
                out.write(b);
            }

        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public void bufferCopy(File source, File destination){
        try(BufferedInputStream in = new BufferedInputStream(new FileInputStream(source));
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(destination))){

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) > 0){
                out.write(buffer, 0, bytesRead);
                out.flush();
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public List<String> write(File destination, List<String> source){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(destination))){
            for(int i = 0; i < source.size(); i++){
                writer.write(source.get(i));
                if(i != source.size() -1){
                    writer.newLine();
                }
            }
            writer.flush();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return source;
    }

    public List<String> read(File source){
        List<String> result = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(source))){
            String line;
            while((line = reader.readLine()) != null){
                result.add(line);
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return result;
    }

    public List<String> readFunctional(String string){
        List<String> result = new ArrayList<>();
        try(BufferedReader reader = Files.newBufferedReader(Paths.get(string))){
            result = reader.lines()
                    .collect(Collectors.toList());
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return result;
    }

    public List<String> readNio(String path) {
        try{
            return Files.lines(Paths.get(path))
                    .collect(Collectors.toList());
        }catch (IOException ex){
            throw new RuntimeException("Something went wrong reading path " + path, ex);
        }
    }
}
