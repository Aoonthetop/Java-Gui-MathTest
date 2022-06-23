package test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class code {
    //定义答案 运算式 正确错误题数 分数
    private int answer;
    private char operator;
    private int num=0;
    private int score=0;
    private int right=0;
    private int wrong=0;
    JFrame jf =new JFrame("四则运算测验");
    JButton btn0=new JButton("出题");
    JButton btn1=new JButton("判断");
    public void init(){
        jf.setLayout(null);
        jf.setBounds(400,400,600,400);
        //定义组件
        final JTextField jl1 = new JTextField();
        final JTextField jl2 =new JTextField();
        final JTextField jl3=new JTextField();
        final JLabel jl4=new JLabel("=");
        final JLabel jl5=new JLabel("");
        final JLabel jl6=new JLabel("");
        final JLabel jl7=new JLabel("");
        final JLabel as =new JLabel();
        final JTextField jt =new JTextField();
        //设计组件样式与格式
        jl1.setBounds(60,50,80,35);
        jl1.setFont(new java.awt.Font("宋体",0, 40));
        jl1.setEditable(false);
        jl2.setBounds(160,50,40,35);
        jl2.setFont(new java.awt.Font("宋体",0, 40));
        jl2.setEditable(false);
        jl3.setBounds(240,50,80,35);
        jl3.setFont(new java.awt.Font("宋体",0, 40));
        jl3.setEditable(false);
        jl4.setBounds(340,50,100,30);
        jl4.setFont(new java.awt.Font("宋体",0, 40));
        jl5.setBounds(60,120,500,30);
        jl5.setFont(new java.awt.Font("宋体",0, 15));
        jl6.setBounds(60,90,500,30);
        jl7.setBounds(60,200,500,30);
        jl7.setFont(new java.awt.Font("宋体",0, 15));
        jt.setBounds(400,50,120,35);
        jt.setFont(new java.awt.Font("宋体",0, 40));
        btn0.setBounds(150,250,100,30);
        btn1.setBounds(350,250,100,30);
        jl6.setText("请出题");
        //定义绑定事件
        btn0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //随机生成数字
                int a=(int)(1+Math.random()*100);
                jl1.setText(a+"");
                int b=(int)(1+Math.random()*100);
                jl3.setText(b+"");
                //随机生成运算式
                if(a < 25){
                    operator = '+';
                    answer = a+b;
                }
                else if(a < 50) {
                    operator = '-';
                    answer = a - b;
                }
                else if(a < 70) {
                    operator = '*';
                    answer = a * b;
                }
                else {
                    operator = '/';
                    answer = a / b;
                }
                //判断后清空Text
                jl2.setText(operator+"");
                jl5.setText("");
                jt.setText("");
                jl6.setText("请出题:第"+(num+=1)+"题");

            }
        });
        //判断逻辑
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //正确时分数与回答正确题数自增
                if(jt.getText().equals(answer+"")){
                    jl5.setText("正确！本题得分为10分。");
                    score+=10;
                    right+=1;
                }else {
                    jl5.setText("错误！本题正确答案为"+answer+"，本题得分为0分");
                    wrong+=1;
                }
                //到达第10道题出分并静止按钮
                if(num>=10){
                    jl7.setText("测验结果，本次测验正确了"+right+"道题,错误"+wrong+"道题，总得分为:"+score+"分");
                    wrong-=1;
                    btn1.setEnabled(false);
                    btn0.setEnabled(false);
                }
            }
        });
        jf.add(jl1);
        jf.add(jl2);
        jf.add(jl3);
        jf.add(jl4);
        jf.add(jl5);
        jf.add(jl6);
        jf.add(jl7);
        jf.add(jt);
        jf.add(btn0);
        jf.add(btn1);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setResizable(false);
    }

    public static void main(String[] args) {
        new code().init();
    }
}