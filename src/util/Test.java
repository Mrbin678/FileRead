package util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Test extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    JButton btn = null;
    JButton btn2 = null;

    JTextField textField = null;
    String filePath = null;

    public Test()
    {
        this.setTitle("选择文件窗口");
        FlowLayout layout = new FlowLayout();// 布局
        JLabel label = new JLabel("请选择文件：");// 标签
        textField = new JTextField(30);// 文本域
        btn = new JButton("浏览");// 钮1
        btn2 = new JButton("确定");//钮2
        // 设置布局
        layout.setAlignment(FlowLayout.LEFT);// 左对齐
        this.setLayout(layout);
        this.setBounds(400, 200, 600, 70);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btn.addActionListener(this);
        this.add(label);
        this.add(textField);
        this.add(btn);

        // 传统按钮监听器添加方式
        btn2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if(filePath!=null){
                    String content = FileReader.readTxt(filePath);
                    System.out.println(content);
                    JOptionPane.showMessageDialog(null, "成功生成对账记录！");
                }
                if(filePath==null){
                    JOptionPane.showMessageDialog(null, "请选择文件！");
               }

            }
        });
        this.add(btn2);

    }

    public static void main(String[] args)
    {
        new Test();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.showDialog(new JLabel(), "选择");
        File file = chooser.getSelectedFile();
        try {
            filePath = file.getAbsoluteFile().toString();
            textField.setText(filePath);
        }catch (Exception e2){
            e2.printStackTrace();
        }
    }
}
