package ru.vsu.cs.kg2020.g102.karaulova_n_a;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private DrawPanel dp;
    public MainWindow() throws HeadlessException {
        dp = new DrawPanel();
        this.add(dp);
    }
}
