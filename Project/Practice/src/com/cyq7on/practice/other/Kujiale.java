package com.cyq7on.practice.other;

import java.io.*;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
* @description
 * 15:06
 * 青干
 * 我们来模拟一下高铁乘车的行为，假设这趟高铁只有一个车厢，售票50张。 需求：
 *
 * 1. 我们有一个文件A存放了已经买票了的乘客，文件里的格式是：
 * 张三 3100001990****0011
 * 李四 3200001988****2222
 * 文件有两列，第一列是乘客名字，第二列是身份证号。
 * 2. 我们有一个文件B存放已经检票的乘客，文件格式和文件A一致，用于做检票记录。
 * 3. 我们有一个检票器，是直接刷身份证：
 * 输入：checkin <身份证号> 如：checkin 3100001990****0011
 * 输出：成功或者失败原因
 * 与此同时，需要在文件B中增加一条检票记录
 * PS：自己考虑和定义可能的失败原因。
 * 4. 买票功能
 * 输入：buy <名字> <身份证号> 如：buy 张三 3100001990****0011
 * 输出：成功或者失败原因。
 * 5. 退票功能
 * 输入：refund <身份证号> 如：refund 3100001990****0011
 * 输出：成功或者失败原因
 *
 * 测试case：
 *
 * buy 张三 310***001  => 成功 or失败
 * buy 李四 310***002  => 成功 or 失败
 *
 * checkin 310***001   => 李四检票成功
 *
 * refund 310***001 => 退票成功
* @author cyq7on
* @create 2020/9/25
**/
public class Kujiale {
    private Map<String,String> aMap;
    private Map<String,String> bMap;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Kujiale kujiale = new Kujiale();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] split = line.split(" ");
            Response response;
            switch (split[0]) {
                case "checkin":
                    response = kujiale.checkin(split[1]);
                    break;
                case "buy":
                    response = kujiale.buy(split[1],split[2]);
                    break;
                case "refund":
                    response = kujiale.refund(split[1]);
                    break;
                default:
                    response = new Response(false, "非法输入");
                    break;
            }
            System.out.println(response);
        }

    }

    static class Response{
        boolean success;
        String info;

        public Response(boolean success, String info) {
            this.success = success;
            this.info = info;
        }

        @Override
        public String toString() {
            return "Response{" +
                    "success=" + success +
                    ", info='" + info + '\'' +
                    '}';
        }
    }

    public Kujiale() {
        aMap = getData("E:\\Project\\Java\\DataStructureAndAlgorithm\\DataStructureAndAlgorithm\\Project\\Practice\\src\\com\\cyq7on\\practice\\other\\A.txt");
        bMap = getData("E:\\Project\\Java\\DataStructureAndAlgorithm\\DataStructureAndAlgorithm\\Project\\Practice\\src\\com\\cyq7on\\practice\\other\\B.txt");
    }

    private Response checkin(String id) {
        boolean b = aMap.containsKey(id);
        String info = null;
        if (b) {
            String name = aMap.get(id);
            bMap.put(name, id);
            //同步至文件
        }
        return new Response(b,info);
    }


    private synchronized Response buy(String name, String id) {
        String info = null;
        boolean b = true;
        if (aMap.size() > 50) {
            b = false;
            info = "票卖光了";
        } else if (aMap.containsKey(id)) {
            b = false;
            info = "您不能重复购票";
        }
        if (b) {
            aMap.put(id, name);
            //同步至文件
        }

        return new Response(b, info);
    }

    private Response refund(String id) {
        String info = null;
        boolean b = true;
        if (!aMap.containsKey(id)) {
            b = false;
            info = "没有查询到此订单";
        } else if (bMap.containsKey(id)) {
            b = false;
            info = "您已检票，无法退票";
        }
        if (b) {
            aMap.remove(id);
        }
        //同步至文件
        return new Response(b, info);
    }


    private Map<String, String> getData(String path) {
        Map<String,String> aMap = new ConcurrentHashMap<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(" ");
                aMap.put(split[1], split[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return aMap;
    }
}
