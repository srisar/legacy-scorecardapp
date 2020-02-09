package gui;

import core.School;
import core.Student;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Saravana
 */
public class ScoreBoard extends javax.swing.JFrame {

    DefaultComboBoxModel<School> leftSchoolComboModel;
    DefaultComboBoxModel<School> rightSchoolComboModel;

    int leftScoreTotal, leftScoreOne, leftScoreTwo, leftScoreThree, leftScoreFour;
    int rightScoreTotal, rightScoreOne, rightScoreTwo, rightScoreThree, rightScoreFour;

    /**
     * Creates new form ScoreBoard
     */
    public ScoreBoard() {
        initComponents();

        bootstrap();

    }

    private void bootstrap() {

        this.setTitle("Score Board by GRAVITIDE");
        splitPane.setResizeWeight(0.5d);
//        JOptionPane.showMessageDialog(null, "Maximise the window for maximum diplay visibility");

        /**
         * setting the width of split pane
         */
        System.out.println("Splitpane width: " + splitPane.getWidth());
        splitPane.setResizeWeight(.5);
        splitPane.setDividerLocation(.5);

        //this.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        /**
         * initializing schools object
         */
        School michaelCollege = new School("St.Cecillias Girl's School", "Batticaloa");
        School carmelFatimaCollege = new School("Carmel Fatima College", "Kalmunai");
        School shivanandaVithiyalayam = new School("Shivananda Vidhyalayam", "Batticaloa");
        School vincentHighSchool = new School("Vincent Girl's High School", "Batticaloa");

        ArrayList<Student> cecilliasStudents = new ArrayList<>();
        cecilliasStudents.add(new Student("K.Yathushana"));
        cecilliasStudents.add(new Student("J.Fatima Jasha"));
        cecilliasStudents.add(new Student("M.Ditharshana"));
        cecilliasStudents.add(new Student("P.Kulanthahi"));
        michaelCollege.setStudents(cecilliasStudents);

        ArrayList<Student> fatimaStudents = new ArrayList<>();
        fatimaStudents.add(new Student("P.C.Dilujan"));
        fatimaStudents.add(new Student("V.Thadsayin"));
        fatimaStudents.add(new Student("U.Henushan"));
        fatimaStudents.add(new Student("T.Kapilathan"));
        carmelFatimaCollege.setStudents(fatimaStudents);

        ArrayList<Student> shivanandaStudents = new ArrayList<>();
        shivanandaStudents.add(new Student("N.Kiruthigan"));
        shivanandaStudents.add(new Student("S.Harshan"));
        shivanandaStudents.add(new Student("V.Hariharan"));
        shivanandaStudents.add(new Student("M.Krishna"));
        shivanandaVithiyalayam.setStudents(shivanandaStudents);

        ArrayList<Student> vincentStudents = new ArrayList<>();
        vincentStudents.add(new Student("Y.Vijithra"));
        vincentStudents.add(new Student("T.Kajahari"));
        vincentStudents.add(new Student("M.M.Fatima Rustha"));
        vincentStudents.add(new Student("K.Abirami"));
        vincentHighSchool.setStudents(vincentStudents);

        leftSchoolComboModel = new DefaultComboBoxModel<>();
        leftSchoolComboModel.addElement(michaelCollege);
        leftSchoolComboModel.addElement(shivanandaVithiyalayam);
        leftSchoolComboModel.addElement(carmelFatimaCollege);
        leftSchoolComboModel.addElement(vincentHighSchool);
        cmbLeftSide.setModel(leftSchoolComboModel);

        rightSchoolComboModel = new DefaultComboBoxModel<>();
        rightSchoolComboModel.addElement(michaelCollege);
        rightSchoolComboModel.addElement(shivanandaVithiyalayam);
        rightSchoolComboModel.addElement(carmelFatimaCollege);
        rightSchoolComboModel.addElement(vincentHighSchool);
        cmbRightSide.setModel(rightSchoolComboModel);

        /**
         * setting initial score values
         */
        leftScoreTotal = 0;
        leftScoreOne = 0;
        leftScoreTwo = 0;
        leftScoreThree = 0;
        leftScoreFour = 0;

        rightScoreTotal = 0;
        rightScoreOne = 0;
        rightScoreTwo = 0;
        rightScoreThree = 0;
        rightScoreFour = 0;

        cmbLeftSide.setSelectedIndex(0);
        fillLeftTextBoxesWithNames((School) cmbLeftSide.getSelectedItem());
        cmbRightSide.setSelectedIndex(1);
        fillRightTextBoxesWithNames((School) cmbRightSide.getSelectedItem());

    }

    public void updateScore() {
        txtScoreLeftOne.setText(String.valueOf(leftScoreOne));
        txtScoreLeftTwo.setText(String.valueOf(leftScoreTwo));
        txtScoreLeftThree.setText(String.valueOf(leftScoreThree));
        txtScoreLeftFour.setText(String.valueOf(leftScoreFour));

        leftScoreTotal = leftScoreOne + leftScoreTwo + leftScoreThree + leftScoreFour;
        txtScoreTotalLeft.setText(String.valueOf(leftScoreTotal));

        txtScoreRightOne.setText(String.valueOf(rightScoreOne));
        txtScoreRightTwo.setText(String.valueOf(rightScoreTwo));
        txtScoreRightThree.setText(String.valueOf(rightScoreThree));
        txtScoreRightFour.setText(String.valueOf(rightScoreFour));

        rightScoreTotal = rightScoreOne + rightScoreTwo + rightScoreThree + rightScoreFour;
        txtScoreTotalRight.setText(String.valueOf(rightScoreTotal));

    }

    public void fillLeftTextBoxesWithNames(School school) {
        txtLeftOne.setText(school.getStudents().get(0).getName());
        txtLeftTwo.setText(school.getStudents().get(1).getName());
        txtLeftThree.setText(school.getStudents().get(2).getName());
        txtLeftFour.setText(school.getStudents().get(3).getName());
    }

    public void fillRightTextBoxesWithNames(School school) {
        txtRightOne.setText(school.getStudents().get(0).getName());
        txtRightTwo.setText(school.getStudents().get(1).getName());
        txtRightThree.setText(school.getStudents().get(2).getName());
        txtRightFour.setText(school.getStudents().get(3).getName());
    }

    public void display() {
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void setMaximized() {
        int result = JOptionPane.showConfirmDialog(this, "Do you want to maximize the window?", "Maximize Window", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            setExtendedState(MAXIMIZED_BOTH);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        splitPane = new javax.swing.JSplitPane();
        leftPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cmbLeftSide = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        txtScoreLeftFour = new javax.swing.JTextField();
        txtScoreLeftThree = new javax.swing.JTextField();
        txtLeftThree = new javax.swing.JTextField();
        txtLeftFour = new javax.swing.JTextField();
        txtLeftTwo = new javax.swing.JTextField();
        txtLeftOne = new javax.swing.JTextField();
        txtScoreLeftOne = new javax.swing.JTextField();
        txtScoreLeftTwo = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        btnLeft1P5 = new javax.swing.JButton();
        btnLeft1P3 = new javax.swing.JButton();
        btnLeft1P1 = new javax.swing.JButton();
        btnLeft1M1 = new javax.swing.JButton();
        btnLeft2M1 = new javax.swing.JButton();
        btnLeft2P1 = new javax.swing.JButton();
        btnLeft2P3 = new javax.swing.JButton();
        btnLeft2P5 = new javax.swing.JButton();
        btnLeft3P5 = new javax.swing.JButton();
        btnLeft3P1 = new javax.swing.JButton();
        btnLeft3M1 = new javax.swing.JButton();
        btnLeft3P3 = new javax.swing.JButton();
        btnLeft4P5 = new javax.swing.JButton();
        btnLeft4P3 = new javax.swing.JButton();
        btnLeft4P1 = new javax.swing.JButton();
        btnLeft4M1 = new javax.swing.JButton();
        rigthPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        cmbRightSide = new javax.swing.JComboBox();
        jPanel9 = new javax.swing.JPanel();
        txtRightOne = new javax.swing.JTextField();
        txtScoreRightOne = new javax.swing.JTextField();
        txtRightTwo = new javax.swing.JTextField();
        txtScoreRightTwo = new javax.swing.JTextField();
        txtScoreRightThree = new javax.swing.JTextField();
        txtScoreRightFour = new javax.swing.JTextField();
        txtRightFour = new javax.swing.JTextField();
        txtRightThree = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        btnRight1P5 = new javax.swing.JButton();
        btnRight1P3 = new javax.swing.JButton();
        btnRight1P1 = new javax.swing.JButton();
        btnRight1M1 = new javax.swing.JButton();
        btnRight2M1 = new javax.swing.JButton();
        btnRight2P1 = new javax.swing.JButton();
        btnRight2P3 = new javax.swing.JButton();
        btnRight2P5 = new javax.swing.JButton();
        btnRight3P5 = new javax.swing.JButton();
        btnRight3P1 = new javax.swing.JButton();
        btnRight3M1 = new javax.swing.JButton();
        btnRight3P3 = new javax.swing.JButton();
        btnRight4P5 = new javax.swing.JButton();
        btnRight4P3 = new javax.swing.JButton();
        btnRight4P1 = new javax.swing.JButton();
        btnRight4M1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtScoreTotalLeft = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtScoreTotalRight = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        lblRound = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        munExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnuResetFields = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuRound1 = new javax.swing.JMenuItem();
        mnuRound2 = new javax.swing.JMenuItem();
        munRound3 = new javax.swing.JMenuItem();
        munRound4 = new javax.swing.JMenuItem();
        munRound5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cmbLeftSide.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        cmbLeftSide.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbLeftSide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLeftSideActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtScoreLeftFour.setEditable(false);
        txtScoreLeftFour.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtScoreLeftFour.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtScoreLeftFour.setText("0");

        txtScoreLeftThree.setEditable(false);
        txtScoreLeftThree.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtScoreLeftThree.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtScoreLeftThree.setText("0");

        txtLeftThree.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        txtLeftFour.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        txtLeftTwo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        txtLeftOne.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        txtScoreLeftOne.setEditable(false);
        txtScoreLeftOne.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtScoreLeftOne.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtScoreLeftOne.setText("0");

        txtScoreLeftTwo.setEditable(false);
        txtScoreLeftTwo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtScoreLeftTwo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtScoreLeftTwo.setText("0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtLeftTwo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(txtLeftThree, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(txtLeftFour, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(txtLeftOne, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtScoreLeftThree, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtScoreLeftFour, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtScoreLeftOne)
                        .addComponent(txtScoreLeftTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLeftOne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtScoreLeftOne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLeftTwo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtScoreLeftTwo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLeftThree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtScoreLeftThree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLeftFour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtScoreLeftFour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnLeft1P5.setText("+5");
        btnLeft1P5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeft1P5ActionPerformed(evt);
            }
        });

        btnLeft1P3.setText("+3");
        btnLeft1P3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeft1P3ActionPerformed(evt);
            }
        });

        btnLeft1P1.setText("+1");
        btnLeft1P1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeft1P1ActionPerformed(evt);
            }
        });

        btnLeft1M1.setText("-1");
        btnLeft1M1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeft1M1ActionPerformed(evt);
            }
        });

        btnLeft2M1.setText("-1");
        btnLeft2M1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeft2M1ActionPerformed(evt);
            }
        });

        btnLeft2P1.setText("+1");
        btnLeft2P1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeft2P1ActionPerformed(evt);
            }
        });

        btnLeft2P3.setText("+3");
        btnLeft2P3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeft2P3ActionPerformed(evt);
            }
        });

        btnLeft2P5.setText("+5");
        btnLeft2P5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeft2P5ActionPerformed(evt);
            }
        });

        btnLeft3P5.setText("+5");
        btnLeft3P5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeft3P5ActionPerformed(evt);
            }
        });

        btnLeft3P1.setText("+1");
        btnLeft3P1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeft3P1ActionPerformed(evt);
            }
        });

        btnLeft3M1.setText("-1");
        btnLeft3M1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeft3M1ActionPerformed(evt);
            }
        });

        btnLeft3P3.setText("+3");
        btnLeft3P3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeft3P3ActionPerformed(evt);
            }
        });

        btnLeft4P5.setText("+5");
        btnLeft4P5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeft4P5ActionPerformed(evt);
            }
        });

        btnLeft4P3.setText("+3");
        btnLeft4P3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeft4P3ActionPerformed(evt);
            }
        });

        btnLeft4P1.setText("+1");
        btnLeft4P1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeft4P1ActionPerformed(evt);
            }
        });

        btnLeft4M1.setText("-1");
        btnLeft4M1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeft4M1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnLeft1P5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLeft1P3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLeft1P1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLeft1M1))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnLeft2P5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLeft2P3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLeft2P1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLeft2M1))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnLeft3P5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLeft3P3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLeft3P1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLeft3M1))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnLeft4P5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLeft4P3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLeft4P1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLeft4M1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLeft1P5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLeft1P3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLeft1P1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLeft1M1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLeft2P5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLeft2P3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLeft2P1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLeft2M1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLeft3P5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLeft3P3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLeft3P1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLeft3M1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLeft4P5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLeft4P3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLeft4P1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLeft4M1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbLeftSide, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbLeftSide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        splitPane.setLeftComponent(leftPanel);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cmbRightSide.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        cmbRightSide.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbRightSide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRightSideActionPerformed(evt);
            }
        });

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtRightOne.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        txtScoreRightOne.setEditable(false);
        txtScoreRightOne.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtScoreRightOne.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtScoreRightOne.setText("0");

        txtRightTwo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        txtScoreRightTwo.setEditable(false);
        txtScoreRightTwo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtScoreRightTwo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtScoreRightTwo.setText("0");

        txtScoreRightThree.setEditable(false);
        txtScoreRightThree.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtScoreRightThree.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtScoreRightThree.setText("0");

        txtScoreRightFour.setEditable(false);
        txtScoreRightFour.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtScoreRightFour.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtScoreRightFour.setText("0");

        txtRightFour.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        txtRightThree.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(txtRightOne)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtScoreRightOne, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(txtRightTwo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtScoreRightTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(txtRightThree)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtScoreRightThree, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(txtRightFour, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtScoreRightFour, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRightOne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtScoreRightOne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRightTwo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtScoreRightTwo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRightThree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtScoreRightThree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRightFour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtScoreRightFour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnRight1P5.setText("+5");
        btnRight1P5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRight1P5ActionPerformed(evt);
            }
        });

        btnRight1P3.setText("+3");
        btnRight1P3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRight1P3ActionPerformed(evt);
            }
        });

        btnRight1P1.setText("+1");
        btnRight1P1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRight1P1ActionPerformed(evt);
            }
        });

        btnRight1M1.setText("-1");
        btnRight1M1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRight1M1ActionPerformed(evt);
            }
        });

        btnRight2M1.setText("-1");
        btnRight2M1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRight2M1ActionPerformed(evt);
            }
        });

        btnRight2P1.setText("+1");
        btnRight2P1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRight2P1ActionPerformed(evt);
            }
        });

        btnRight2P3.setText("+3");
        btnRight2P3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRight2P3ActionPerformed(evt);
            }
        });

        btnRight2P5.setText("+5");
        btnRight2P5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRight2P5ActionPerformed(evt);
            }
        });

        btnRight3P5.setText("+5");
        btnRight3P5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRight3P5ActionPerformed(evt);
            }
        });

        btnRight3P1.setText("+1");
        btnRight3P1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRight3P1ActionPerformed(evt);
            }
        });

        btnRight3M1.setText("-1");
        btnRight3M1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRight3M1ActionPerformed(evt);
            }
        });

        btnRight3P3.setText("+3");
        btnRight3P3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRight3P3ActionPerformed(evt);
            }
        });

        btnRight4P5.setText("+5");
        btnRight4P5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRight4P5ActionPerformed(evt);
            }
        });

        btnRight4P3.setText("+3");
        btnRight4P3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRight4P3ActionPerformed(evt);
            }
        });

        btnRight4P1.setText("+1");
        btnRight4P1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRight4P1ActionPerformed(evt);
            }
        });

        btnRight4M1.setText("-1");
        btnRight4M1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRight4M1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(btnRight1P5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRight1P3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRight1P1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRight1M1))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(btnRight2P5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRight2P3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRight2P1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRight2M1))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(btnRight3P5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRight3P3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRight3P1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRight3M1))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(btnRight4P5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRight4P3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRight4P1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRight4M1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRight1P5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRight1P3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRight1P1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRight1M1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRight2P5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRight2P3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRight2P1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRight2M1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRight3P5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRight3P3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRight3P1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRight3M1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRight4P5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRight4P3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRight4P1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRight4M1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbRightSide, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbRightSide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout rigthPanelLayout = new javax.swing.GroupLayout(rigthPanel);
        rigthPanel.setLayout(rigthPanelLayout);
        rigthPanelLayout.setHorizontalGroup(
            rigthPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rigthPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        rigthPanelLayout.setVerticalGroup(
            rigthPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rigthPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        splitPane.setRightComponent(rigthPanel);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("TOTAL SCORE");

        txtScoreTotalLeft.setFont(new java.awt.Font("Tahoma", 1, 200)); // NOI18N
        txtScoreTotalLeft.setForeground(new java.awt.Color(0, 204, 0));
        txtScoreTotalLeft.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtScoreTotalLeft.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addComponent(txtScoreTotalLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtScoreTotalLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("TOTAL SCORE");

        txtScoreTotalRight.setFont(new java.awt.Font("Tahoma", 1, 200)); // NOI18N
        txtScoreTotalRight.setForeground(new java.awt.Color(0, 204, 0));
        txtScoreTotalRight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtScoreTotalRight.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtScoreTotalRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtScoreTotalRight, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblRound.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblRound.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRound.setText("ROUND ONE");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/gravitide-logo.png"))); // NOI18N

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("This app is brought to you by LightFrost.net");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/eia-logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRound, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRound)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenu1.setText("File");

        munExit.setText("Exit");
        munExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                munExitActionPerformed(evt);
            }
        });
        jMenu1.add(munExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Options");

        mnuResetFields.setText("Reset Fields");
        mnuResetFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuResetFieldsActionPerformed(evt);
            }
        });
        jMenu2.add(mnuResetFields);
        jMenu2.add(jSeparator1);

        mnuRound1.setText("Round One");
        mnuRound1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRound1ActionPerformed(evt);
            }
        });
        jMenu2.add(mnuRound1);

        mnuRound2.setText("Round Two");
        mnuRound2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRound2ActionPerformed(evt);
            }
        });
        jMenu2.add(mnuRound2);

        munRound3.setText("Round Three");
        munRound3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                munRound3ActionPerformed(evt);
            }
        });
        jMenu2.add(munRound3);

        munRound4.setText("Round Four");
        munRound4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                munRound4ActionPerformed(evt);
            }
        });
        jMenu2.add(munRound4);

        munRound5.setText("Round Five");
        munRound5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                munRound5ActionPerformed(evt);
            }
        });
        jMenu2.add(munRound5);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(splitPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(splitPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbRightSideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRightSideActionPerformed
        // TODO add your handling code here:
        School selectedSchool = (School) cmbRightSide.getSelectedItem();
        fillRightTextBoxesWithNames(selectedSchool);
    }//GEN-LAST:event_cmbRightSideActionPerformed

    private void cmbLeftSideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLeftSideActionPerformed
        // TODO add your handling code here:
        School selectedSchool = (School) cmbLeftSide.getSelectedItem();
        fillLeftTextBoxesWithNames(selectedSchool);
    }//GEN-LAST:event_cmbLeftSideActionPerformed

    private void btnLeft1P5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeft1P5ActionPerformed
        // TODO add your handling code here:
        leftScoreOne += 5;
        updateScore();
    }//GEN-LAST:event_btnLeft1P5ActionPerformed

    private void btnLeft1P3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeft1P3ActionPerformed
        // TODO add your handling code here:
        leftScoreOne += 3;
        updateScore();
    }//GEN-LAST:event_btnLeft1P3ActionPerformed

    private void btnLeft1P1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeft1P1ActionPerformed
        // TODO add your handling code here:
        leftScoreOne += 1;
        updateScore();
    }//GEN-LAST:event_btnLeft1P1ActionPerformed

    private void btnLeft1M1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeft1M1ActionPerformed
        // TODO add your handling code here:
        leftScoreOne -= 1;
        updateScore();
    }//GEN-LAST:event_btnLeft1M1ActionPerformed

    private void btnLeft2P5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeft2P5ActionPerformed
        // TODO add your handling code here:
        leftScoreTwo += 5;
        updateScore();
    }//GEN-LAST:event_btnLeft2P5ActionPerformed

    private void btnLeft2P3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeft2P3ActionPerformed
        // TODO add your handling code here:
        leftScoreTwo += 3;
        updateScore();
    }//GEN-LAST:event_btnLeft2P3ActionPerformed

    private void btnLeft2P1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeft2P1ActionPerformed
        // TODO add your handling code here:
        leftScoreTwo += 1;
        updateScore();
    }//GEN-LAST:event_btnLeft2P1ActionPerformed

    private void btnLeft2M1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeft2M1ActionPerformed
        // TODO add your handling code here:
        leftScoreTwo -= 1;
        updateScore();
    }//GEN-LAST:event_btnLeft2M1ActionPerformed

    private void btnLeft3P5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeft3P5ActionPerformed
        // TODO add your handling code here:
        leftScoreThree += 5;
        updateScore();
    }//GEN-LAST:event_btnLeft3P5ActionPerformed

    private void btnLeft3P3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeft3P3ActionPerformed
        // TODO add your handling code here:
        leftScoreThree += 3;
        updateScore();
    }//GEN-LAST:event_btnLeft3P3ActionPerformed

    private void btnLeft3P1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeft3P1ActionPerformed
        // TODO add your handling code here:
        leftScoreThree += 1;
        updateScore();
    }//GEN-LAST:event_btnLeft3P1ActionPerformed

    private void btnLeft3M1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeft3M1ActionPerformed
        // TODO add your handling code here:
        leftScoreThree -= 1;
        updateScore();
    }//GEN-LAST:event_btnLeft3M1ActionPerformed

    private void btnLeft4P5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeft4P5ActionPerformed
        // TODO add your handling code here:
        leftScoreFour += 5;
        updateScore();
    }//GEN-LAST:event_btnLeft4P5ActionPerformed

    private void btnLeft4P3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeft4P3ActionPerformed
        // TODO add your handling code here:
        leftScoreFour += 3;
        updateScore();
    }//GEN-LAST:event_btnLeft4P3ActionPerformed

    private void btnLeft4P1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeft4P1ActionPerformed
        // TODO add your handling code here:
        leftScoreFour += 1;
        updateScore();
    }//GEN-LAST:event_btnLeft4P1ActionPerformed

    private void btnLeft4M1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeft4M1ActionPerformed
        // TODO add your handling code here:
        leftScoreFour -= 1;
        updateScore();
    }//GEN-LAST:event_btnLeft4M1ActionPerformed

    private void btnRight1P5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRight1P5ActionPerformed
        // TODO add your handling code here:
        rightScoreOne += 5;
        updateScore();
    }//GEN-LAST:event_btnRight1P5ActionPerformed

    private void btnRight1P3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRight1P3ActionPerformed
        // TODO add your handling code here:
        rightScoreOne += 3;
        updateScore();
    }//GEN-LAST:event_btnRight1P3ActionPerformed

    private void btnRight1P1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRight1P1ActionPerformed
        // TODO add your handling code here:
        rightScoreOne += 1;
        updateScore();
    }//GEN-LAST:event_btnRight1P1ActionPerformed

    private void btnRight1M1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRight1M1ActionPerformed
        // TODO add your handling code here:
        rightScoreOne -= 1;
        updateScore();
    }//GEN-LAST:event_btnRight1M1ActionPerformed

    private void btnRight2P5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRight2P5ActionPerformed
        // TODO add your handling code here:
        rightScoreTwo += 5;
        updateScore();
    }//GEN-LAST:event_btnRight2P5ActionPerformed

    private void btnRight2P3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRight2P3ActionPerformed
        // TODO add your handling code here:
        rightScoreTwo += 3;
        updateScore();
    }//GEN-LAST:event_btnRight2P3ActionPerformed

    private void btnRight2P1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRight2P1ActionPerformed
        // TODO add your handling code here:
        rightScoreTwo += 1;
        updateScore();
    }//GEN-LAST:event_btnRight2P1ActionPerformed

    private void btnRight2M1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRight2M1ActionPerformed
        // TODO add your handling code here:
        rightScoreTwo -= 1;
        updateScore();
    }//GEN-LAST:event_btnRight2M1ActionPerformed

    private void btnRight3P5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRight3P5ActionPerformed
        // TODO add your handling code here:
        rightScoreThree += 5;
        updateScore();
    }//GEN-LAST:event_btnRight3P5ActionPerformed

    private void btnRight3P3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRight3P3ActionPerformed
        // TODO add your handling code here:
        rightScoreThree += 3;
        updateScore();
    }//GEN-LAST:event_btnRight3P3ActionPerformed

    private void btnRight3P1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRight3P1ActionPerformed
        // TODO add your handling code here:
        rightScoreThree += 1;
        updateScore();
    }//GEN-LAST:event_btnRight3P1ActionPerformed

    private void btnRight3M1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRight3M1ActionPerformed
        // TODO add your handling code here:
        rightScoreThree -= 1;
        updateScore();
    }//GEN-LAST:event_btnRight3M1ActionPerformed

    private void btnRight4P5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRight4P5ActionPerformed
        // TODO add your handling code here:
        rightScoreFour += 5;
        updateScore();
    }//GEN-LAST:event_btnRight4P5ActionPerformed

    private void btnRight4P3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRight4P3ActionPerformed
        // TODO add your handling code here:
        rightScoreFour += 3;
        updateScore();
    }//GEN-LAST:event_btnRight4P3ActionPerformed

    private void btnRight4P1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRight4P1ActionPerformed
        // TODO add your handling code here:
        rightScoreFour += 1;
        updateScore();
    }//GEN-LAST:event_btnRight4P1ActionPerformed

    private void btnRight4M1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRight4M1ActionPerformed
        // TODO add your handling code here:
        rightScoreFour -= 1;
        updateScore();
    }//GEN-LAST:event_btnRight4M1ActionPerformed

    private void munExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_munExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_munExitActionPerformed

    private void mnuResetFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuResetFieldsActionPerformed
        // TODO add your handling code here:

        int result = JOptionPane.showConfirmDialog(rootPane, "Do you want to reset all fields?\nThis action cannot be reversed!", "Confirm Reset", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            txtLeftOne.setText("");
            txtLeftTwo.setText("");
            txtLeftThree.setText("");
            txtLeftFour.setText("");

            txtRightOne.setText("");
            txtRightTwo.setText("");
            txtRightThree.setText("");
            txtRightFour.setText("");

            leftScoreOne = 0;
            leftScoreTwo = 0;
            leftScoreThree = 0;
            leftScoreFour = 0;
            leftScoreTotal = 0;

            rightScoreOne = 0;
            rightScoreTwo = 0;
            rightScoreThree = 0;
            rightScoreFour = 0;
            rightScoreTotal = 0;

            updateScore();
        }

    }//GEN-LAST:event_mnuResetFieldsActionPerformed

    private void mnuRound1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRound1ActionPerformed
        // TODO add your handling code here:
        lblRound.setText("ROUND ONE");
    }//GEN-LAST:event_mnuRound1ActionPerformed

    private void mnuRound2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRound2ActionPerformed
        // TODO add your handling code here:
        lblRound.setText("ROUND TWO");
    }//GEN-LAST:event_mnuRound2ActionPerformed

    private void munRound3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_munRound3ActionPerformed
        // TODO add your handling code here:
        lblRound.setText("ROUND THREE");
    }//GEN-LAST:event_munRound3ActionPerformed

    private void munRound4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_munRound4ActionPerformed
        // TODO add your handling code here:
        lblRound.setText("ROUND FOUR");
    }//GEN-LAST:event_munRound4ActionPerformed

    private void munRound5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_munRound5ActionPerformed
        // TODO add your handling code here:
        lblRound.setText("ROUND FIVE");
    }//GEN-LAST:event_munRound5ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLeft1M1;
    private javax.swing.JButton btnLeft1P1;
    private javax.swing.JButton btnLeft1P3;
    private javax.swing.JButton btnLeft1P5;
    private javax.swing.JButton btnLeft2M1;
    private javax.swing.JButton btnLeft2P1;
    private javax.swing.JButton btnLeft2P3;
    private javax.swing.JButton btnLeft2P5;
    private javax.swing.JButton btnLeft3M1;
    private javax.swing.JButton btnLeft3P1;
    private javax.swing.JButton btnLeft3P3;
    private javax.swing.JButton btnLeft3P5;
    private javax.swing.JButton btnLeft4M1;
    private javax.swing.JButton btnLeft4P1;
    private javax.swing.JButton btnLeft4P3;
    private javax.swing.JButton btnLeft4P5;
    private javax.swing.JButton btnRight1M1;
    private javax.swing.JButton btnRight1P1;
    private javax.swing.JButton btnRight1P3;
    private javax.swing.JButton btnRight1P5;
    private javax.swing.JButton btnRight2M1;
    private javax.swing.JButton btnRight2P1;
    private javax.swing.JButton btnRight2P3;
    private javax.swing.JButton btnRight2P5;
    private javax.swing.JButton btnRight3M1;
    private javax.swing.JButton btnRight3P1;
    private javax.swing.JButton btnRight3P3;
    private javax.swing.JButton btnRight3P5;
    private javax.swing.JButton btnRight4M1;
    private javax.swing.JButton btnRight4P1;
    private javax.swing.JButton btnRight4P3;
    private javax.swing.JButton btnRight4P5;
    private javax.swing.JComboBox cmbLeftSide;
    private javax.swing.JComboBox cmbRightSide;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lblRound;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JMenuItem mnuResetFields;
    private javax.swing.JMenuItem mnuRound1;
    private javax.swing.JMenuItem mnuRound2;
    private javax.swing.JMenuItem munExit;
    private javax.swing.JMenuItem munRound3;
    private javax.swing.JMenuItem munRound4;
    private javax.swing.JMenuItem munRound5;
    private javax.swing.JPanel rigthPanel;
    private javax.swing.JSplitPane splitPane;
    private javax.swing.JTextField txtLeftFour;
    private javax.swing.JTextField txtLeftOne;
    private javax.swing.JTextField txtLeftThree;
    private javax.swing.JTextField txtLeftTwo;
    private javax.swing.JTextField txtRightFour;
    private javax.swing.JTextField txtRightOne;
    private javax.swing.JTextField txtRightThree;
    private javax.swing.JTextField txtRightTwo;
    private javax.swing.JTextField txtScoreLeftFour;
    private javax.swing.JTextField txtScoreLeftOne;
    private javax.swing.JTextField txtScoreLeftThree;
    private javax.swing.JTextField txtScoreLeftTwo;
    private javax.swing.JTextField txtScoreRightFour;
    private javax.swing.JTextField txtScoreRightOne;
    private javax.swing.JTextField txtScoreRightThree;
    private javax.swing.JTextField txtScoreRightTwo;
    private javax.swing.JLabel txtScoreTotalLeft;
    private javax.swing.JLabel txtScoreTotalRight;
    // End of variables declaration//GEN-END:variables
}
