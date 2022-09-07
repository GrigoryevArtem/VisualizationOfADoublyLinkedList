package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Main {
    public static void main(String[] args) throws Exception {


      final int btnHeight = 80;
        final int rectangleX = 90;
        final int rectangleY = 70;


        List<Integer> list = new List();

        JFrame Form = new JFrame();
        Form.setVisible(true);
        Form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        Form.setBounds(0, 0, dimension.width, dimension.height);
        Form.setTitle("Visualization of a doubly linked list");

        Form.setExtendedState(JFrame.MAXIMIZED_BOTH);


        JPanel panelOne = new JPanel();

        Form.add(panelOne);
        panelOne.setLayout(null);
        panelOne.setBackground(Color.gray);

        Font fontToButton = new Font("TimesRoman", Font.BOLD, 18);
        Font fontTwo = new Font("TimesRoman", Font.BOLD, 14);

        JButton insertFirst = new JButton("Insert First");
        forCreateButton(insertFirst, panelOne, 5, 5, Form.getSize().width / 4, btnHeight, fontToButton);

        JButton insertLast = new JButton("Insert Last");
        forCreateButton(insertLast, panelOne, 5 + Form.getSize().width / 4, 5, Form.getSize().width / 4, btnHeight, fontToButton);

        JButton deleteLast = new JButton("Delete Last");
        forCreateButton(deleteLast, panelOne, 5 + 2 * Form.getSize().width / 4, 5, Form.getSize().width / 4, btnHeight, fontToButton);

        JButton deleteFirst = new JButton("Delete First");
        forCreateButton(deleteFirst, panelOne, 3 * Form.getSize().width / 4, 5, Form.getSize().width / 4 - 5, btnHeight, fontToButton);

        JButton insertByIndex = new JButton("Insert by Index");
        forCreateButton(insertByIndex, panelOne, 5, 5 + btnHeight, Form.getSize().width / 4, btnHeight, fontToButton);

        JButton deleteByIndex = new JButton("Delete by Index");
        forCreateButton(deleteByIndex, panelOne, 5 + Form.getSize().width / 4, 5 + btnHeight, Form.getSize().width / 4, btnHeight, fontToButton);

        JButton deleteByKey = new JButton("Delete by Key");
        forCreateButton(deleteByKey, panelOne, 5 + 2 * Form.getSize().width / 4, 5 + btnHeight, Form.getSize().width / 4, btnHeight, fontToButton);

        JButton clearing = new JButton("Clearing");
        forCreateButton(clearing, panelOne, 5 + 3 * Form.getSize().width / 4, 5 + btnHeight, Form.getSize().width / 4-5, btnHeight, fontToButton);


        JPanel panelTwo = new JPanel();
        panelOne.add(panelTwo);
        panelTwo.setLayout(null);
        panelTwo.setBounds(5, 5 + 2 * btnHeight, Form.getSize().width - 10, 100);
        panelTwo.setBackground(Color.white);


        JLabel enterNumber = new JLabel("Enter number from -9999 to 9999:");
        forCreateLabel(enterNumber, 15, 15, 250, 30, fontTwo, Color.black);
        panelTwo.add(enterNumber);

        JTextField tfForKey = new JTextField();
        panelTwo.add(tfForKey);
        tfForKey.setBounds(15, 50, 250, 40);
        tfForKey.setFont(fontToButton);

        JLabel enterIndex = new JLabel("Enter index:");
        forCreateLabel(enterIndex, 5 + Form.getSize().width / 4, 15, 250, 30, fontTwo, Color.black);
        panelTwo.add(enterIndex);

        JTextField tfForIndex = new JTextField();
        panelTwo.add(tfForIndex);
        tfForIndex.setBounds(5 + Form.getSize().width / 4, 50, 250, 40);
        tfForIndex.setFont(fontToButton);


        JLabel information = new JLabel();
        forCreateLabel(information, 5 + Form.getSize().width / 2, 15, Form.getSize().width - 10, 80, fontTwo, Color.black);
        panelTwo.add(information);


        Draw drawing = new Draw();
        panelOne.add(drawing);
        drawing.setBackground(Color.lightGray);
        drawing.setBounds(5, 5 + 2 * btnHeight + 100, Form.getSize().width - 10, Form.getSize().height - (5 + 2 * btnHeight + 100));

        drawing.setIgnoreRepaint(true);
        Graphics graphic = drawing.getGraphics();
        graphic.setFont(new Font("TimesRoman", Font.BOLD, 14));


        Form.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                //if (!list.isEmpty())
                //  drawing.paint(graphic, list, rectangleX, rectangleY, Form,tfForIndex);
            }

            @Override
            public void componentMoved(ComponentEvent e) {
                if (!list.isEmpty())
                    drawing.paint(graphic, list, rectangleX, rectangleY, Form, tfForIndex,btnHeight);
            }

            @Override
            public void componentShown(ComponentEvent e) {
                //  if (!list.isEmpty())
                //      drawing.paint(graphic, list, rectangleX, rectangleY, Form,tfForIndex);
            }

            @Override
            public void componentHidden(ComponentEvent e) {
                //  if (!list.isEmpty())
                //      drawing.paint(graphic, list, rectangleX, rectangleY, Form,tfForIndex);
            }
        });
        insertFirst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try {

                    if (!tfForKey.getText().isEmpty()) {
                        if (Integer.parseInt(tfForKey.getText()) > 9999 || Integer.parseInt(tfForKey.getText()) < -9999)
                            JOptionPane.showMessageDialog(null, "Warning!The user entered a value that goes beyond the set limits!", "Error!", JOptionPane.WARNING_MESSAGE);
                        else {
                            // drawing.validate();

                            list.insertFirst(Integer.parseInt(tfForKey.getText()));
                            graphic.clearRect(0, 0, Form.getSize().width - 10, Form.getSize().height - (5 + 2 * btnHeight + 100));
                            drawing.paint(graphic, list, rectangleX, rectangleY, Form, tfForIndex,btnHeight);
                            information.setText("An element with the value " + tfForKey.getText() + " was inserted at the beginning of the doubly linked list");
                            tfForKey.setText("");
                            tfForIndex.setText("");


                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Nothing to add!The user did not enter a number!", "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException c) {
                    JOptionPane.showMessageDialog(null, "This is not a number!", "Error!", JOptionPane.ERROR_MESSAGE);
                }


            }
        });
        insertLast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    if (!tfForKey.getText().isEmpty()) {
                        if (Integer.parseInt(tfForKey.getText()) > 9999 || Integer.parseInt(tfForKey.getText()) < -9999)
                            JOptionPane.showMessageDialog(null, "Warning!The user entered a value that goes beyond the set limits!", "Error!", JOptionPane.WARNING_MESSAGE);
                        else {

                            list.insertLast(Integer.parseInt(tfForKey.getText()));
                            graphic.clearRect(0, 0, Form.getSize().width - 10, Form.getSize().height - (5 + 2 * btnHeight + 100));
                            drawing.paint(graphic, list, rectangleX, rectangleY, Form, tfForIndex,btnHeight);
                            information.setText("An element with the value " + tfForKey.getText() + " was inserted at the end of the doubly linked list");
                            tfForKey.setText("");
                            tfForIndex.setText("");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Nothing to add!The user did not enter a number!", "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException c) {
                    JOptionPane.showMessageDialog(null, "This is not a number!", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        deleteFirst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    if (!list.isEmpty()) {
                        information.setText("An item with the value " + list.getHead().data + "  was deleted at the beginning of the doubly linked list");
                        list.deleteFirst();
                        graphic.clearRect(0, 0, Form.getSize().width - 10, Form.getSize().height);
                        if (!list.isEmpty())
                            drawing.paint(graphic, list, rectangleX, rectangleY, Form, tfForIndex,btnHeight);
                        tfForKey.setText("");
                        tfForIndex.setText("");
                    } else
                        JOptionPane.showMessageDialog(null, "Nothing to delete!The doubly linked list is empty!", "Error!", JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException c) {
                    JOptionPane.showMessageDialog(null, "An error has occurred!Repeat the action!", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        deleteLast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!list.isEmpty()) {
                        information.setText("An item with the value " + list.getTail().data + "  was deleted at the end of the doubly linked list");
                        list.deleteLast();
                        graphic.clearRect(0, 0, Form.getSize().width - 10, Form.getSize().height);
                        if (!list.isEmpty())
                            drawing.paint(graphic, list, rectangleX, rectangleY, Form, tfForIndex,btnHeight);
                        tfForKey.setText("");
                        tfForIndex.setText("");
                    } else
                        JOptionPane.showMessageDialog(null, "Nothing to delete!The doubly linked list is empty!", "Error!", JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException c) {
                    JOptionPane.showMessageDialog(null, "An error has occurred!Repeat the action!", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        insertByIndex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    if ((!tfForKey.getText().isEmpty() || !tfForIndex.getText().isEmpty()) && Integer.parseInt(tfForIndex.getText()) <= list.getSize()) {
                        if (Integer.parseInt(tfForKey.getText()) > 9999 || Integer.parseInt(tfForKey.getText()) < -9999)
                            JOptionPane.showMessageDialog(null, "Warning!The user entered a value that goes beyond the set limits!", "Error!", JOptionPane.WARNING_MESSAGE);
                        else {
                            list.insertIndex(Integer.parseInt(tfForIndex.getText()), Integer.parseInt(tfForKey.getText()));
                            graphic.clearRect(0, 0, Form.getSize().width - 10, Form.getSize().height - (5 + 2 * btnHeight + 100));
                            drawing.paint(graphic, list, rectangleX, rectangleY, Form, tfForIndex,btnHeight);
                            information.setText("An element with the value " + tfForKey.getText() + " under index " + tfForIndex.getText() + " was inserted into the doubly linked list");
                            tfForKey.setText("");
                            tfForIndex.setText("");
                        }
                    } else if (Integer.parseInt(tfForIndex.getText()) > list.getSize())
                        JOptionPane.showMessageDialog(null, "The entered index is outside the number of items in the doubly linked list!", "Error!", JOptionPane.ERROR_MESSAGE);
                    else {
                        JOptionPane.showMessageDialog(null, "Nothing to add!The user did not enter a number!", "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException c) {
                    JOptionPane.showMessageDialog(null, "This is not a number!", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        deleteByIndex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    if (!list.isEmpty() && Integer.parseInt(tfForIndex.getText()) < list.getSize()) {
                        information.setText("An element with the value " + list.search(Integer.parseInt(tfForIndex.getText())).data + " under index " + tfForIndex.getText() + " was deleted into the doubly linked list");
                        list.deleteIndex(Integer.parseInt(tfForIndex.getText()));
                        graphic.clearRect(0, 0, Form.getSize().width - 10, Form.getSize().height);
                        if (!list.isEmpty())
                            drawing.paint(graphic, list, rectangleX, rectangleY, Form, tfForIndex,btnHeight);
                        tfForKey.setText("");
                        tfForIndex.setText("");
                    } else if (Integer.parseInt(tfForIndex.getText()) >= list.getSize())
                        JOptionPane.showMessageDialog(null, "The entered index is outside the number of items in the doubly linked list!", "Error!", JOptionPane.ERROR_MESSAGE);
                    else {
                        JOptionPane.showMessageDialog(null, "Nothing to delete!The user did not enter a number!", "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException c) {
                    JOptionPane.showMessageDialog(null, "This is not a number!", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        deleteByKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    if (!list.isEmpty()) {
                        if (Integer.parseInt(tfForKey.getText()) > 9999 || Integer.parseInt(tfForKey.getText()) < -9999)
                            JOptionPane.showMessageDialog(null, "Warning!The user entered a value that goes beyond the set limits!", "Error!", JOptionPane.WARNING_MESSAGE);
                        else {

                            list.deleteKey(Integer.parseInt(tfForKey.getText()));
                            information.setText("all items in the doubly linked list with a value of " + tfForKey.getText() + " were removed");
                            graphic.clearRect(0, 0, Form.getSize().width - 10, Form.getSize().height);
                            if (!list.isEmpty())
                                drawing.paint(graphic, list, rectangleX, rectangleY, Form, tfForIndex,btnHeight);
                            tfForKey.setText("");
                            tfForIndex.setText("");
                        }
                    } else
                        JOptionPane.showMessageDialog(null, "Nothing to delete!The user did not enter a number!", "Error!", JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException c) {
                    JOptionPane.showMessageDialog(null, "This is not a number!", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        clearing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!list.isEmpty()) {

                        information.setText("The doubly linked list has been cleared,there are currently no items in it");
                        graphic.clearRect(0, 0, Form.getSize().width - 10, Form.getSize().height);
                        list.clear();
                        tfForKey.setText("");
                        tfForIndex.setText("");
                    } else
                        JOptionPane.showMessageDialog(null, "Nothing to delete!The doubly linked list is empty!", "Error!", JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException c) {
                    JOptionPane.showMessageDialog(null, "An error has occurred!Repeat the action!", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void forCreateButton(JButton button, JPanel panel, int x, int y, int width, int height, Font font) {

        button.setBounds(x, y, width, height);
        panel.add(button);
        button.setFont(font);
    }
    public static void forCreateLabel(JLabel label, int x, int y, int width, int height, Font font, Color color) {
        label.setBounds(x, y, width, height);
        label.setBackground(color);
        label.setFont(font);
    }

   public static class Draw extends Canvas{


        public void paint (Graphics graphics, List<Integer> list, int rectangleX, int rectangleY, JFrame Form, JTextField jTF,int btnH)
        {int rectX=rectangleX;int rectY=rectangleY;
            super.paint(graphics);

            graphics.setFont(new Font("TimesRoman",Font.BOLD,12));
            Node current = list.getHead();
            if (!list.isEmpty())
                graphics.drawString("NULL", rectangleX - 70, rectangleY + 28);

            while (current != null) {

                graphics.setColor(Color.white);



                graphics.fillRect(rectangleX, rectangleY, 50, 50);
                graphics.setColor(Color.black);
                graphics.drawRect(rectangleX, rectangleY, 50, 50);
                graphics.drawString(String.valueOf(current.data), rectangleX + 12, rectangleY + 28);


                if (rectangleX < Form.getSize().width - 100)
                    drawArrow(graphics, false, rectangleX, rectangleY, rectangleX + btnH,btnH,rectX,rectY);
                rectangleX += 80;

                if (rectangleY > Form.getSize().height - 400 && rectangleX >= Form.getSize().width - 100) {
                    graphics.drawString("NULL", rectangleX, rectangleY + 28);
                    JOptionPane.showMessageDialog(null, "The doubly linked list has reached its maximum size!Please delete a certain number of items and continue working.", "Warning!", JOptionPane.WARNING_MESSAGE);

                    return;
                } else if (rectangleX >= Form.getSize().width - 100) {
                    drawArrow(graphics, true, rectangleX, rectangleY, rectangleX + btnH,btnH,rectX,rectY);
                    rectangleX = rectX;
                    rectangleY += 100;
                }

                current = current.next;
            }

            graphics.drawString("NULL", rectangleX, rectangleY + 28);


        }
        public void drawArrow(Graphics graphics, boolean direction, int x1, int y, int x2,int btnH,int rectX,int rectY) {


            y += 30;

            if (!direction) {
                //prev
                graphics.drawLine(x1, y, x2, y);
                graphics.drawLine(x2, y, x2 - 4, y - 4);
                graphics.drawLine(x2, y, x2 - 4, y + 4);

                y -= 15;
                x1 -= 30;
                x2 -= 30;
                //next
                graphics.drawLine(x2, y, x1, y);
                graphics.drawLine(x1, y, x1 + 4, y - 4);
                graphics.drawLine(x1, y, x1 + 4, y + 4);
            } else {
                //for next
                x1 -= 30;
                x2 -= 30;

                graphics.drawPolyline(new int[]{x2 - 20, x1 - 20, x2 - 20, x2 - 20, 15, 15, rectX}, new int[]{y, y, y, y + 40, y + 40, y + rectY+30, y + rectY+30}, 7);
                graphics.drawLine(rectX, y + rectY+30, rectX - 4, y + rectY+30 - 4);
                graphics.drawLine(rectX, y + rectY+30, rectX - 4, y + rectY+30 + 4);

                //for previous
                y -= 15;
                graphics.drawPolyline(new int[]{x2, x1, x2, x2, 25, 25, rectX}, new int[]{y, y, y, y + rectY, y + rectY, y + rectY+30, y + rectY+30}, 7);
                graphics.drawLine(x1, y, x1 + 4, y - 4);
                graphics.drawLine(x1, y, x1 + 4, y + 4);


            }
        }

    }
}




