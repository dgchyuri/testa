package projava;

import java.util.Scanner;

public class NumberChoice {
    public static void main(String[] args) {
        System.out.println("ゲーム開始！");

        Scanner sc = new Scanner(System.in);  //キーボードで入力された内容を受け取る準備

        // SecretNumberのオブジェクト生成
        SecretNumber secret = new SecretNumber();
        secret.setSecret();


        int number; // 箱を準備

        while (true) {
            System.out.print("1から100までの数字を入力してください: ");
            String input = sc.nextLine();  // ← まず String で受け取る


            /* 数字かどうか判定する */
            try {
                number = Integer.parseInt(input);  // ← 数字ならここで int に変換される
            } catch (NumberFormatException e) {
                System.out.println("文字ではなく数字を入力してください");
                continue;
            }

            /* 1〜100 の範囲判定 */
            if (number < 1 || number > 100) {
                System.out.println("数字は1から100を選んでください");
                continue;
            }


            String result = secret.judge(number);

            // 受け取った結果に応じてメッセージを表示
            if (result.equals("大きい")) {
                System.out.println("もっと小さいです。再度入力してください。");
            } else if (result.equals("小さい")) {
                System.out.println("もっと大きいです。再度入力してください。");
            } else {
                System.out.println("正解です！");
                break; // 正解ならループ終了
            }
        }
    }
}



