/**
 * Created by Kafukaaa on 2017/6/7.
 */

import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;

public class Command {
    public static ArrayList<String> executeCmds(String[] cmds) {
        ArrayList<String> outPuts = new ArrayList<String>();
        try {
            ProcessBuilder pb = new ProcessBuilder(cmds);
            Process process = pb.start();
            process.waitFor();
            InputStreamReader ir = new InputStreamReader(process.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);
            String line;
            while ((line = input.readLine()) != null) {
                outPuts.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return outPuts;
    }

    public static void main(String[] args) {
        String cmds[] = new String[3];
        if(System.getProperty("os.name").contains("Mac OS")){
            cmds[0]="/bin/bash";
            cmds[1]="-c";
        }
        else if(System.getProperty("os.name").contains("Windows")){
            cmds[0]="cmd.exe";
            cmds[1]="/c";
        }
        else if(System.getProperty("os.name").contains("Linux")){
            cmds[0]="/bin/bash";
            cmds[1]="-c";
        }else {
            System.err.println("Cmds: The System is not supported");
        }

        cmds[2] = "ls";
//        cmds[2] = "cd coding/dlb_client && ./dlb_client -h";
        ArrayList<String> outPuts = executeCmds(cmds);

        for (int i = 0; i < outPuts.size(); i++) {
            System.out.println(outPuts.get(i));
        }

    }
}