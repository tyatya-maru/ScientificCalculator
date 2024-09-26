package com.scientific_calculator;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Dentaku extends JFrame {
  private static final long serialVersionUID = 1L;

  JPanel contentPane = new JPanel();
  BorderLayout borderLayout = new BorderLayout();
  JTextField result = new JTextField(); // 計算結果を表示するテキストフィールド

  double stackedValue = 0.0; // 演算子ボタンを押す前にテキストフィールドにあった値
  double tentative = 1.0; // 計算する上での仮の値
  boolean isStacked = false; // stackValueに数値を入力したがどうか
  boolean afterCalc = false; // 演算子ボタンを押した後がどうか
  int pattern = 1; // JPanelのパターン表示
  String currentOp = ""; // 押された演算子ボタンの名前

  // フレームのビルド
  public Dentaku() {
    contentPane.setLayout(borderLayout);
    this.setSize(new Dimension(800, 500));
    this.setTitle("電子式関数計算機");
    this.setContentPane(contentPane);

    contentPane.add(result, BorderLayout.NORTH); // テキストフィールドを設置

    JPanel keyPanel = new JPanel(); // ボタンをレイアウトにはめこんでいく
    keyPanel.setLayout(new GridLayout(5, 10)); // 10行5列のGridLayoutにする
    contentPane.add(keyPanel, BorderLayout.CENTER);

    if (pattern == 1) {
      keyPanel.add(new Button("("), 0);
      keyPanel.add(new Button(")"), 1);
      keyPanel.add(new Button("mc"), 2);
      keyPanel.add(new Button("m+"), 3);
      keyPanel.add(new Button("m-"), 4);
      keyPanel.add(new Button("mr"), 5);
      keyPanel.add(new ClearButton("AC"), 6);
      keyPanel.add(new InversionButton("+/-"), 7);
      keyPanel.add(new CalcButton("%"), 8);
      keyPanel.add(new CalcButton("÷"), 9);
      keyPanel.add(new PatternButton("2nd"), 10);
      keyPanel.add(new CalButton("x^2"), 11);
      keyPanel.add(new CalButton("x^3"), 12);
      keyPanel.add(new CalcButton("x^y"), 13);
      keyPanel.add(new CalButton("e^x"), 14);
      keyPanel.add(new CalButton("10^x"), 15);
      keyPanel.add(new NumberButton("7"), 16);
      keyPanel.add(new NumberButton("8"), 17);
      keyPanel.add(new NumberButton("9"), 18);
      keyPanel.add(new CalcButton("×"), 19);
      keyPanel.add(new CalButton("1/x"), 20);
      keyPanel.add(new CalButton("2√x"), 21);
      keyPanel.add(new CalButton("3√x"), 22);
      keyPanel.add(new CalcButton("y√x"), 23);
      keyPanel.add(new CalButton("ln"), 24);
      keyPanel.add(new CalButton("log10"), 25);
      keyPanel.add(new NumberButton("4"), 26);
      keyPanel.add(new NumberButton("5"), 27);
      keyPanel.add(new NumberButton("6"), 28);
      keyPanel.add(new CalcButton("-"), 29);
      keyPanel.add(new CalButton("x!"), 30);
      keyPanel.add(new CalButton("sin"), 31);
      keyPanel.add(new CalButton("cos"), 32);
      keyPanel.add(new CalButton("tan"), 33);
      keyPanel.add(new FunctionButton("e"), 34);
      keyPanel.add(new CalcButton("EE"), 35);
      keyPanel.add(new NumberButton("1"), 36);
      keyPanel.add(new NumberButton("2"), 37);
      keyPanel.add(new NumberButton("3"), 38);
      keyPanel.add(new CalcButton("+"), 39);
      keyPanel.add(new Button("Rad"), 40);
      keyPanel.add(new CalButton("sinh"), 41);
      keyPanel.add(new CalButton("cosh"), 42);
      keyPanel.add(new CalButton("tanh"), 43);
      keyPanel.add(new FunctionButton("π"), 44);
      keyPanel.add(new FunctionButton("Rand"), 45);
      keyPanel.add(new NumberButton("0"), 46);
      keyPanel.add(new NumberButton("00"), 47);
      keyPanel.add(new NumberButton("."), 48);
      keyPanel.add(new CalcButton("="), 49);
    } else if (pattern == 2) {
      keyPanel.add(new Button("("), 0);
      keyPanel.add(new Button(")"), 1);
      keyPanel.add(new Button("mc"), 2);
      keyPanel.add(new Button("m+"), 3);
      keyPanel.add(new Button("m-"), 4);
      keyPanel.add(new Button("mr"), 5);
      keyPanel.add(new ClearButton("AC"), 6);
      keyPanel.add(new InversionButton("+/-"), 7);
      keyPanel.add(new CalcButton("%"), 8);
      keyPanel.add(new CalcButton("÷"), 9);
      keyPanel.add(new PatternButton("2nd"), 10);
      keyPanel.add(new CalButton("x^2"), 11);
      keyPanel.add(new CalButton("x^3"), 12);
      keyPanel.add(new CalcButton("x^y"), 13);
      keyPanel.add(new CalButton("y^x"), 14);
      keyPanel.add(new CalButton("2^x"), 15);
      keyPanel.add(new NumberButton("7"), 16);
      keyPanel.add(new NumberButton("8"), 17);
      keyPanel.add(new NumberButton("9"), 18);
      keyPanel.add(new CalcButton("×"), 19);
      keyPanel.add(new CalButton("1/x"), 20);
      keyPanel.add(new CalButton("2√x"), 21);
      keyPanel.add(new CalButton("3√x"), 22);
      keyPanel.add(new CalcButton("y√x"), 23);
      keyPanel.add(new CalButton("logy"), 24);
      keyPanel.add(new CalButton("log2"), 25);
      keyPanel.add(new NumberButton("4"), 26);
      keyPanel.add(new NumberButton("5"), 27);
      keyPanel.add(new NumberButton("6"), 28);
      keyPanel.add(new CalcButton("-"), 29);
      keyPanel.add(new CalButton("x!"), 30);
      keyPanel.add(new CalButton("sin^-1"), 31);
      keyPanel.add(new CalButton("cos^-1"), 32);
      keyPanel.add(new CalButton("tan^-1"), 33);
      keyPanel.add(new FunctionButton("e"), 34);
      keyPanel.add(new CalcButton("EE"), 35);
      keyPanel.add(new NumberButton("1"), 36);
      keyPanel.add(new NumberButton("2"), 37);
      keyPanel.add(new NumberButton("3"), 38);
      keyPanel.add(new CalcButton("+"), 39);
      keyPanel.add(new Button("Rad"), 40);
      keyPanel.add(new CalButton("sinh^-1"), 41);
      keyPanel.add(new CalButton("cosh^-1"), 42);
      keyPanel.add(new CalButton("tanh^-1"), 43);
      keyPanel.add(new FunctionButton("π"), 44);
      keyPanel.add(new FunctionButton("Rand"), 45);
      keyPanel.add(new NumberButton("0"), 46);
      keyPanel.add(new NumberButton("00"), 47);
      keyPanel.add(new NumberButton("."), 48);
      keyPanel.add(new CalcButton("="), 49);
    }
    this.setVisible(true);
  }

  // テキストフィールドの引数の文字列をつなげる
  public void appendResult(String c) {
    if (!afterCalc) { // 演算子ボタンを押した直後でないなら
      result.setText(result.getText() + c);
    } else {
      result.setText(c); // 押したボタンの文字列だけを設定する
      afterCalc = false;
    }
  }

  // 数字を入力するボタンの定義
  public class NumberButton extends JButton implements ActionListener {
    private static final long serialVersionUID = 1L;

    public NumberButton(String keyTop) {
      super(keyTop); // JButtonクラスのコンストラクタを呼び出す
      this.addActionListener(this); // このボタンにアクションイベントのリスナを追加
    }

    public void actionPerformed(ActionEvent evt) {
      String keyNumber = this.getText(); // ボタンの名前を取り出す
      appendResult(keyNumber); // ボタンの名前をテキストフィールドにつなげる
    }
  }

  // 関数式を入力するボタンの定義
  public class FunctionButton extends JButton implements ActionListener {
    private static final long serialVersionUID = 1L;

    public FunctionButton(String keyTop) {
      super(keyTop);
      this.addActionListener(this);
    }

    public void actionPerformed(ActionEvent evt) {
      String functionNumber = this.getText();
      result.setText("");
      if (functionNumber == "e") {
        tentative = Math.E;
        appendResult(Double.toString(tentative));
      } else if (functionNumber == "π") {
        tentative = Math.PI;
        appendResult(Double.toString(tentative));
      } else if (functionNumber == "Rand") {
        tentative = Math.random();
        appendResult(Double.toString(tentative));
      }
      afterCalc = true;
    }
  }

  // 演算子ボタンを定義
  public class CalcButton extends JButton implements ActionListener {
    private static final long serialVersionUID = 1L;

    public CalcButton(String op) {
      super(op);
      this.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
      if (isStacked) { // 以前に演算子ボタンが押されたのなら計算結果を取り出す
        double resultValue = (Double.valueOf(result.getText())).doubleValue();
        if (currentOp.equals("+")) { // 演算子に応じて計算する
          stackedValue += resultValue;
        } else if (currentOp.equals("-")) {
          stackedValue -= resultValue;
        } else if (currentOp.equals("×")) {
          stackedValue *= resultValue;
        } else if (currentOp.equals("÷")) {
          stackedValue /= resultValue;
        } else if (currentOp.equals("%")) {
          stackedValue %= resultValue;
        } else if (currentOp.equals("x^y")) {
          stackedValue = Math.pow(stackedValue, resultValue);
        } else if (currentOp.equals("y√x")) {
          stackedValue = Math.pow(stackedValue, 1 / resultValue);
        } else if (currentOp.equals("EE")) {
          stackedValue = stackedValue * Math.pow(10, resultValue);
        }
        result.setText(String.valueOf(stackedValue)); // 計算結果をテキストフィールドの設置
      }
      currentOp = this.getText(); // ボタン名から押されたボタンの演算子を取り出す
      stackedValue = (Double.valueOf(result.getText()).doubleValue());
      afterCalc = true;
      if (currentOp.equals("=")) {
        isStacked = false;
      } else {
        isStacked = true;
      }
    }
  }

  // 演算子ボタン（引数1つ）の定義
  public class CalButton extends JButton implements ActionListener {
    private static final long serialVersionUID = 1L;

    public CalButton(String op) {
      super(op);
      this.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
      currentOp = this.getText();
      stackedValue = (Double.valueOf(result.getText())).doubleValue();
      if (currentOp.equals("x^2")) {
        stackedValue = Math.pow(stackedValue, 2.0);
      } else if (currentOp.equals("x^3")) {
        stackedValue = Math.pow(stackedValue, 3);
      } else if (currentOp.equals("10^x")) {
        stackedValue = Math.pow(10, stackedValue);
      } else if (currentOp.equals("e^x")) {
        stackedValue = Math.exp(stackedValue);
      } else if (currentOp.equals("1/x")) {
        stackedValue = 1 / stackedValue;
      } else if (currentOp.equals("2√x")) {
        stackedValue = Math.sqrt(stackedValue);
      } else if (currentOp.equals("3√x")) {
        stackedValue = Math.cbrt(stackedValue);
      } else if (currentOp.equals("ln")) {
        stackedValue = Math.log(stackedValue);
      } else if (currentOp.equals("log10")) {
        stackedValue = Math.log10(stackedValue);
      } else if (currentOp.equals("x!")) {
        for (double n = 1.0; n <= stackedValue; n++) {
          tentative *= n;
        }
        stackedValue = tentative;
      } else if (currentOp.equals("sin")) {
        stackedValue = Math.sin(Math.toRadians(stackedValue));
      } else if (currentOp.equals("cos")) {
        stackedValue = Math.cos(Math.toRadians(stackedValue));
      } else if (currentOp.equals("tan")) {
        stackedValue = Math.tan(Math.toRadians(stackedValue));
      } else if (currentOp.equals("sinh")) {
        stackedValue = Math.sinh(stackedValue);
      } else if (currentOp.equals("cosh")) {
        stackedValue = Math.cosh(stackedValue);
      } else if (currentOp.equals("tanh")) {
        stackedValue = Math.tanh(stackedValue);
      }
      result.setText(String.valueOf(stackedValue));
    }
  }

  // 反転ボタンの定義
  public class InversionButton extends JButton implements ActionListener {
    private static final long serialVersionUID = 1L;

    public InversionButton(String inv) {
      super(inv);
      this.addActionListener(this);
    }

    public void actionPerformed(ActionEvent evt) {
      String inversion = result.getText();
      double inv = Double.parseDouble(inversion);
      inv *= -1;
      result.setText(String.valueOf(inv));
    }
  }

  // 入れ替えボタンの定義
  public class PatternButton extends JButton implements ActionListener {
    private static final long serialVersionUID = 1L;

    public PatternButton(String pat) {
      super(pat);
      this.addActionListener(this);
    }

    public void actionPerformed(ActionEvent evt) {
      if (pattern == 1) {
        pattern = 2;
      } else if (pattern == 2) {
        pattern = 1;
      }
    }
  }

  // クリアボタンの定義
  public class ClearButton extends JButton implements ActionListener {
    private static final long serialVersionUID = 1L;

    public ClearButton(String clear) {
      // TODO 自動生成されたコンストラクター・スタブ
      super("AC");
      this.addActionListener(this);
    }

    public void actionPerformed(ActionEvent evt) {
      stackedValue = 0.0;
      tentative = 1.0;
      afterCalc = false;
      isStacked = false;
      result.setText("");
    }
  }

}
