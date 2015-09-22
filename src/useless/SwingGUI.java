package useless;

import core.ResourcesManager;
import java.awt.CardLayout;

public class SwingGUI extends javax.swing.JFrame {
    
    //================================================================================
    // Fields
    //================================================================================

    private CardLayout connectBodyLayout;

    //================================================================================
    // Constructors
    //================================================================================
    public SwingGUI(ResourcesManager rManager) {
        initComponents();
        connectBodyLayout = (CardLayout)connectBodyPanel.getLayout();
    }

    //================================================================================
    // NetBeans - auto generated
    //================================================================================
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        mainPanel = new javax.swing.JPanel();
        connectPanel = new javax.swing.JPanel();
        connectHeadPanel = new javax.swing.JPanel();
        signInButton = new javax.swing.JButton();
        registerButton = new javax.swing.JButton();
        connectBodyPanel = new javax.swing.JPanel();
        loginPanel = new javax.swing.JPanel();
        loginUserField = new javax.swing.JTextField();
        loginPasswordField = new javax.swing.JPasswordField();
        loginUserLabel = new javax.swing.JLabel();
        loginPasswordLabel = new javax.swing.JLabel();
        loginConnectButton = new javax.swing.JButton();
        applyPanel = new javax.swing.JPanel();
        applyUserLabel = new javax.swing.JLabel();
        applyUserField = new javax.swing.JTextField();
        applyPasswordLabel = new javax.swing.JLabel();
        applyPasswordField = new javax.swing.JPasswordField();
        applyPassword2Label = new javax.swing.JLabel();
        applyPassword2Field = new javax.swing.JPasswordField();
        applyFirstNameLabel = new javax.swing.JLabel();
        applyFirstNameField = new javax.swing.JTextField();
        applyLastNameLabel = new javax.swing.JLabel();
        applyLastNameField = new javax.swing.JTextField();
        applyLanguageComboBox = new javax.swing.JComboBox();
        applyLanguageLabel = new javax.swing.JLabel();
        applySalaryLabel = new javax.swing.JLabel();
        applySalaryField = new javax.swing.JTextField();
        applyApplyButton = new javax.swing.JButton();
        experienceLabel = new javax.swing.JLabel();
        experienceComboBox = new javax.swing.JComboBox();
        AdminPanel = new javax.swing.JPanel();
        adminMenuPanel = new javax.swing.JPanel();
        adminMenuEmployeeAppliesButton = new javax.swing.JButton();
        adminMenuEmployeesManagerButton = new javax.swing.JButton();
        adminMenuTeamListButton = new javax.swing.JButton();
        adminMenuMessagesButton = new javax.swing.JButton();
        adminInfoPanel = new javax.swing.JPanel();
        adminInfoLabel = new javax.swing.JLabel();
        adminMainPanel = new javax.swing.JPanel();
        adminMessagesPanel = new javax.swing.JPanel();
        adminMessagesHeadPanel = new javax.swing.JPanel();
        adminMessagesMailBoxButton = new javax.swing.JButton();
        adminMessagesNewMessageButton = new javax.swing.JButton();
        adminMessagesBodyPanel = new javax.swing.JPanel();
        adminMessagesNewMessagePanel = new javax.swing.JPanel();
        adminMessagesTypeLabel = new javax.swing.JLabel();
        adminMessagesTypeComboBox = new javax.swing.JComboBox();
        adminMessagesToLabel = new javax.swing.JLabel();
        adminMessagesToComboBox = new javax.swing.JComboBox();
        adminMessagesTextPanel = new javax.swing.JScrollPane();
        adminMessagesMessageTextArea = new javax.swing.JTextArea();
        adminMessagesTitleTextField = new javax.swing.JTextField();
        adminMessagesTitleLabel = new javax.swing.JLabel();
        adminMessagesScrollPanel = new javax.swing.JScrollPane();
        adminMessagesTable = new javax.swing.JTable();
        adminTeamsPanel = new javax.swing.JPanel();
        adminTeamsHeadPanel = new javax.swing.JPanel();
        adminTeamsOverviewButton = new javax.swing.JButton();
        adminTeamsCreateButton = new javax.swing.JButton();
        adminTeamsBodyPanel = new javax.swing.JPanel();
        adminTeamsCreatePanel = new javax.swing.JPanel();
        adminTeamsNameLabel = new javax.swing.JLabel();
        adminTeamsTechnologyLabel = new javax.swing.JLabel();
        adminTeamsNameTextField = new javax.swing.JTextField();
        adminTeamsTechnologyComboBox = new javax.swing.JComboBox();
        adminTeamsOverviewPanel = new javax.swing.JScrollPane();
        adminTeamsTable = new javax.swing.JTable();
        adminEmployeesPanel = new javax.swing.JPanel();
        adminEmployeesHeadPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        adminEmployeesTablePanel = new javax.swing.JScrollPane();
        adminEmployeesTable = new javax.swing.JTable();
        adminEmployeesSummaryPanel = new javax.swing.JPanel();
        employeesAmountLabel = new javax.swing.JLabel();
        employeesExperienceLabel = new javax.swing.JLabel();
        employeesJuniorAmountLabel = new javax.swing.JLabel();
        employeesExperienceJuniorLabel = new javax.swing.JLabel();
        employeesRegularAmountLabel = new javax.swing.JLabel();
        employeesExperienceRegularLabel = new javax.swing.JLabel();
        employeesSeniorAmountLabel = new javax.swing.JLabel();
        employeesExperienceSerniorLabel = new javax.swing.JLabel();
        employeesManagersAmountLabel = new javax.swing.JLabel();
        employeesExperienceManagersLabel = new javax.swing.JLabel();
        amount = new javax.swing.JLabel();
        exp = new javax.swing.JLabel();
        charge = new javax.swing.JLabel();
        average = new javax.swing.JLabel();
        juniorsChargeLabel = new javax.swing.JLabel();
        regularsChargeLabel = new javax.swing.JLabel();
        seniorsChargeLabel = new javax.swing.JLabel();
        managersChargeLabel = new javax.swing.JLabel();
        chargeLabel = new javax.swing.JLabel();
        juniorsAverageLabel = new javax.swing.JLabel();
        regularsAverageLabel = new javax.swing.JLabel();
        seniorsAverageLabel = new javax.swing.JLabel();
        managersAverageLabel = new javax.swing.JLabel();
        averageLabel = new javax.swing.JLabel();
        adminAppliesPanel = new javax.swing.JPanel();
        adminAppliesHeadPanel = new javax.swing.JPanel();
        adminAppliesLabel = new javax.swing.JLabel();
        adminAppliesLabel2 = new javax.swing.JLabel();
        adminAppliesDecisionPanel = new javax.swing.JPanel();
        adminAppliesHireButton = new javax.swing.JButton();
        adminAppliesRejectButton = new javax.swing.JButton();
        adminAppliesLaterButton = new javax.swing.JButton();
        adminAppliesApplyPanel = new javax.swing.JPanel();
        adminAppliesNameLabel = new javax.swing.JLabel();
        adminAppliesLastNameLabel = new javax.swing.JLabel();
        adminAppliesExperienceLabel = new javax.swing.JLabel();
        adminAppliesLanguageLabel = new javax.swing.JLabel();
        adminAppliesSalaryLabel = new javax.swing.JLabel();
        EmployeePanel = new javax.swing.JPanel();
        emplInfoPanel = new javax.swing.JPanel();
        emplFirstNameLabel = new javax.swing.JLabel();
        emplLastNameLabel = new javax.swing.JLabel();
        emplExperienceLabel = new javax.swing.JLabel();
        emplSalaryLabel = new javax.swing.JLabel();
        emplLanguageLabel = new javax.swing.JLabel();
        emplTeamLabel = new javax.swing.JLabel();
        emplMenuPanel = new javax.swing.JPanel();
        emplTeamViewButton = new javax.swing.JButton();
        emplMessagesButton = new javax.swing.JButton();
        emplAskForPromotionButton = new javax.swing.JButton();
        emplChangePasswordButton = new javax.swing.JButton();
        emplMainPanel = new javax.swing.JPanel();
        emplMessagesPanel = new javax.swing.JPanel();
        emplMessagesHeadPanel = new javax.swing.JPanel();
        emplMessagesMailBoxButton = new javax.swing.JButton();
        emplMessagesNewMessageButton = new javax.swing.JButton();
        emplMessagesBodyPanel = new javax.swing.JPanel();
        emplMessagesNewMessagePanel = new javax.swing.JPanel();
        emplMessagesTypeLabel = new javax.swing.JLabel();
        emplMessagesTypeComboBox = new javax.swing.JComboBox();
        emplMessagesToLabel = new javax.swing.JLabel();
        emplMessagesToComboBox = new javax.swing.JComboBox();
        emplMessagesTextPanel = new javax.swing.JScrollPane();
        emplMessagesMessageTextArea = new javax.swing.JTextArea();
        emplMessagesTitleTextField = new javax.swing.JTextField();
        emplMessagesTitleLabel = new javax.swing.JLabel();
        emplMessagesScrollPanel = new javax.swing.JScrollPane();
        emplMessagesTable = new javax.swing.JTable();
        emplChangePasswordPanel = new javax.swing.JPanel();
        emplCurrentPasswordLabel = new javax.swing.JLabel();
        emplNewPasswordLabel = new javax.swing.JLabel();
        emplConfirmLabel = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jPasswordField3 = new javax.swing.JPasswordField();
        emplSubmitChangePasswordButton = new javax.swing.JButton();
        emplAskForPromotionPanel = new javax.swing.JPanel();
        emplAskSalaryChangeCheckBox = new javax.swing.JCheckBox();
        emplAskExperienceChangeCheckBox = new javax.swing.JCheckBox();
        emplAskSalaryTextField = new javax.swing.JTextField();
        emplAskExperienceComboBox = new javax.swing.JComboBox();
        emplAskSubmitButton = new javax.swing.JButton();
        emplTeamViewPanel = new javax.swing.JPanel();
        emplTeamViewLabel = new javax.swing.JLabel();
        emplScrollPanel = new javax.swing.JScrollPane();
        emplTeamTable = new javax.swing.JTable();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Company Management System");
        setLocation(new java.awt.Point(400, 300));
        setMinimumSize(new java.awt.Dimension(300, 300));
        setResizable(false);

        mainPanel.setLayout(new java.awt.CardLayout());

        connectPanel.setName("card1"); // NOI18N
        connectPanel.setPreferredSize(new java.awt.Dimension(500, 400));

        connectHeadPanel.setMinimumSize(new java.awt.Dimension(300, 100));
        connectHeadPanel.setLayout(new java.awt.GridBagLayout());

        signInButton.setText("Sign in");
        signInButton.setEnabled(false);
        signInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 21;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(10, 24, 10, 24);
        connectHeadPanel.add(signInButton, gridBagConstraints);

        registerButton.setText("Register");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 21;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(10, 24, 10, 24);
        connectHeadPanel.add(registerButton, gridBagConstraints);

        connectBodyPanel.setLayout(new java.awt.CardLayout());

        loginPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        loginPanel.setLayout(new java.awt.GridBagLayout());

        loginUserField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        loginUserField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginUserFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 120;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 10, 7);
        loginPanel.add(loginUserField, gridBagConstraints);

        loginPasswordField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        loginPasswordField.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 120;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 10, 7);
        loginPanel.add(loginPasswordField, gridBagConstraints);

        loginUserLabel.setText("user");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 10, 7);
        loginPanel.add(loginUserLabel, gridBagConstraints);

        loginPasswordLabel.setText("password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 10, 7);
        loginPanel.add(loginPasswordLabel, gridBagConstraints);

        loginConnectButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        loginConnectButton.setText("Connect");
        loginConnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginConnectButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(28, 0, 28, 0);
        loginPanel.add(loginConnectButton, gridBagConstraints);

        connectBodyPanel.add(loginPanel, "loginCard");

        applyPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        applyPanel.setLayout(new java.awt.GridBagLayout());

        applyUserLabel.setText("user name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 3, 5);
        applyPanel.add(applyUserLabel, gridBagConstraints);

        applyUserField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 120;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 3, 5);
        applyPanel.add(applyUserField, gridBagConstraints);

        applyPasswordLabel.setText("your password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 3, 5);
        applyPanel.add(applyPasswordLabel, gridBagConstraints);

        applyPasswordField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 120;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 3, 5);
        applyPanel.add(applyPasswordField, gridBagConstraints);

        applyPassword2Label.setText("repeat password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 3, 5);
        applyPanel.add(applyPassword2Label, gridBagConstraints);

        applyPassword2Field.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 120;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 3, 5);
        applyPanel.add(applyPassword2Field, gridBagConstraints);

        applyFirstNameLabel.setText("first name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 3, 5);
        applyPanel.add(applyFirstNameLabel, gridBagConstraints);

        applyFirstNameField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 120;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 3, 5);
        applyPanel.add(applyFirstNameField, gridBagConstraints);

        applyLastNameLabel.setText("last name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 3, 5);
        applyPanel.add(applyLastNameLabel, gridBagConstraints);

        applyLastNameField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 120;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 3, 5);
        applyPanel.add(applyLastNameField, gridBagConstraints);

        applyLanguageComboBox.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        applyLanguageComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Java", "C#", "C++", "PHP", "RoR" }));
        applyLanguageComboBox.setMinimumSize(new java.awt.Dimension(60, 30));
        applyLanguageComboBox.setPreferredSize(new java.awt.Dimension(60, 30));
        applyLanguageComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyLanguageComboBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 3, 5);
        applyPanel.add(applyLanguageComboBox, gridBagConstraints);

        applyLanguageLabel.setText("programming language");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 3, 5);
        applyPanel.add(applyLanguageLabel, gridBagConstraints);

        applySalaryLabel.setText("preffered salary");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 3, 5);
        applyPanel.add(applySalaryLabel, gridBagConstraints);

        applySalaryField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 120;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 3, 5);
        applyPanel.add(applySalaryField, gridBagConstraints);

        applyApplyButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        applyApplyButton.setText("Apply");
        applyApplyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyApplyButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        applyPanel.add(applyApplyButton, gridBagConstraints);

        experienceLabel.setText("experience");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        applyPanel.add(experienceLabel, gridBagConstraints);

        experienceComboBox.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        experienceComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Junior", "Middle", "Senior", "Manager" }));
        experienceComboBox.setMinimumSize(new java.awt.Dimension(60, 30));
        experienceComboBox.setPreferredSize(new java.awt.Dimension(60, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 70;
        applyPanel.add(experienceComboBox, gridBagConstraints);

        connectBodyPanel.add(applyPanel, "applyCard");

        javax.swing.GroupLayout connectPanelLayout = new javax.swing.GroupLayout(connectPanel);
        connectPanel.setLayout(connectPanelLayout);
        connectPanelLayout.setHorizontalGroup(
            connectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, connectPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(connectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(connectBodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(connectHeadPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE))
                .addContainerGap())
        );
        connectPanelLayout.setVerticalGroup(
            connectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(connectPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(connectHeadPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(connectBodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainPanel.add(connectPanel, "card1");

        AdminPanel.setName("card1"); // NOI18N
        AdminPanel.setPreferredSize(new java.awt.Dimension(500, 400));

        adminMenuPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        adminMenuPanel.setMaximumSize(new java.awt.Dimension(156, 276));
        adminMenuPanel.setMinimumSize(new java.awt.Dimension(156, 276));
        adminMenuPanel.setPreferredSize(new java.awt.Dimension(156, 276));
        adminMenuPanel.setLayout(new java.awt.GridBagLayout());

        adminMenuEmployeeAppliesButton.setText("Applies");
        adminMenuEmployeeAppliesButton.setEnabled(false);
        adminMenuEmployeeAppliesButton.setMaximumSize(new java.awt.Dimension(125, 25));
        adminMenuEmployeeAppliesButton.setMinimumSize(new java.awt.Dimension(125, 25));
        adminMenuEmployeeAppliesButton.setPreferredSize(new java.awt.Dimension(125, 25));
        adminMenuEmployeeAppliesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminMenuEmployeeAppliesButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipady = 16;
        gridBagConstraints.insets = new java.awt.Insets(11, 11, 11, 11);
        adminMenuPanel.add(adminMenuEmployeeAppliesButton, gridBagConstraints);

        adminMenuEmployeesManagerButton.setText("Employees");
        adminMenuEmployeesManagerButton.setMaximumSize(new java.awt.Dimension(125, 25));
        adminMenuEmployeesManagerButton.setMinimumSize(new java.awt.Dimension(125, 25));
        adminMenuEmployeesManagerButton.setPreferredSize(new java.awt.Dimension(125, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.insets = new java.awt.Insets(11, 11, 11, 11);
        adminMenuPanel.add(adminMenuEmployeesManagerButton, gridBagConstraints);

        adminMenuTeamListButton.setText("Teams");
        adminMenuTeamListButton.setMaximumSize(new java.awt.Dimension(125, 25));
        adminMenuTeamListButton.setMinimumSize(new java.awt.Dimension(125, 25));
        adminMenuTeamListButton.setPreferredSize(new java.awt.Dimension(125, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.insets = new java.awt.Insets(11, 11, 11, 11);
        adminMenuPanel.add(adminMenuTeamListButton, gridBagConstraints);

        adminMenuMessagesButton.setText("Messages");
        adminMenuMessagesButton.setMaximumSize(new java.awt.Dimension(125, 25));
        adminMenuMessagesButton.setMinimumSize(new java.awt.Dimension(125, 25));
        adminMenuMessagesButton.setPreferredSize(new java.awt.Dimension(125, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.insets = new java.awt.Insets(11, 11, 11, 11);
        adminMenuPanel.add(adminMenuMessagesButton, gridBagConstraints);

        adminInfoPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        adminInfoPanel.setMaximumSize(new java.awt.Dimension(156, 80));
        adminInfoPanel.setMinimumSize(new java.awt.Dimension(156, 80));
        adminInfoPanel.setPreferredSize(new java.awt.Dimension(156, 80));
        adminInfoPanel.setLayout(new java.awt.GridBagLayout());

        adminInfoLabel.setForeground(new java.awt.Color(255, 0, 51));
        adminInfoLabel.setText("Admin panel");
        adminInfoPanel.add(adminInfoLabel, new java.awt.GridBagConstraints());

        adminMainPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        adminMainPanel.setLayout(new java.awt.CardLayout());

        adminMessagesPanel.setPreferredSize(new java.awt.Dimension(283, 300));

        adminMessagesHeadPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        adminMessagesHeadPanel.setLayout(new java.awt.GridBagLayout());

        adminMessagesMailBoxButton.setText("Mail box");
        adminMessagesMailBoxButton.setMaximumSize(new java.awt.Dimension(110, 35));
        adminMessagesMailBoxButton.setMinimumSize(new java.awt.Dimension(110, 35));
        adminMessagesMailBoxButton.setPreferredSize(new java.awt.Dimension(110, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 24, 10, 24);
        adminMessagesHeadPanel.add(adminMessagesMailBoxButton, gridBagConstraints);

        adminMessagesNewMessageButton.setText("New Message");
        adminMessagesNewMessageButton.setEnabled(false);
        adminMessagesNewMessageButton.setMaximumSize(new java.awt.Dimension(110, 35));
        adminMessagesNewMessageButton.setMinimumSize(new java.awt.Dimension(110, 35));
        adminMessagesNewMessageButton.setPreferredSize(new java.awt.Dimension(110, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 24, 10, 24);
        adminMessagesHeadPanel.add(adminMessagesNewMessageButton, gridBagConstraints);

        adminMessagesBodyPanel.setLayout(new java.awt.CardLayout());

        adminMessagesNewMessagePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        adminMessagesNewMessagePanel.setLayout(new java.awt.GridBagLayout());

        adminMessagesTypeLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        adminMessagesTypeLabel.setText("Type");
        adminMessagesTypeLabel.setMaximumSize(new java.awt.Dimension(80, 25));
        adminMessagesTypeLabel.setMinimumSize(new java.awt.Dimension(80, 25));
        adminMessagesTypeLabel.setPreferredSize(new java.awt.Dimension(80, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(2, 6, 2, 6);
        adminMessagesNewMessagePanel.add(adminMessagesTypeLabel, gridBagConstraints);

        adminMessagesTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Team", "Manager", "Explicit employee", "All" }));
        adminMessagesTypeComboBox.setMaximumSize(new java.awt.Dimension(160, 25));
        adminMessagesTypeComboBox.setMinimumSize(new java.awt.Dimension(160, 25));
        adminMessagesTypeComboBox.setPreferredSize(new java.awt.Dimension(160, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(2, 6, 2, 6);
        adminMessagesNewMessagePanel.add(adminMessagesTypeComboBox, gridBagConstraints);

        adminMessagesToLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        adminMessagesToLabel.setText("To");
        adminMessagesToLabel.setMaximumSize(new java.awt.Dimension(80, 25));
        adminMessagesToLabel.setMinimumSize(new java.awt.Dimension(80, 25));
        adminMessagesToLabel.setPreferredSize(new java.awt.Dimension(80, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(2, 6, 2, 6);
        adminMessagesNewMessagePanel.add(adminMessagesToLabel, gridBagConstraints);

        adminMessagesToComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Kuba", "Jakub", "Jakces", " " }));
        adminMessagesToComboBox.setMaximumSize(new java.awt.Dimension(160, 25));
        adminMessagesToComboBox.setMinimumSize(new java.awt.Dimension(160, 25));
        adminMessagesToComboBox.setPreferredSize(new java.awt.Dimension(160, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(2, 6, 2, 6);
        adminMessagesNewMessagePanel.add(adminMessagesToComboBox, gridBagConstraints);

        adminMessagesMessageTextArea.setColumns(20);
        adminMessagesMessageTextArea.setLineWrap(true);
        adminMessagesMessageTextArea.setRows(5);
        adminMessagesTextPanel.setViewportView(adminMessagesMessageTextArea);
        emplMessagesMessageTextArea.setLineWrap(true);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 7;
        gridBagConstraints.insets = new java.awt.Insets(11, 11, 11, 11);
        adminMessagesNewMessagePanel.add(adminMessagesTextPanel, gridBagConstraints);

        adminMessagesTitleTextField.setMaximumSize(new java.awt.Dimension(160, 25));
        adminMessagesTitleTextField.setMinimumSize(new java.awt.Dimension(160, 25));
        adminMessagesTitleTextField.setPreferredSize(new java.awt.Dimension(160, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(2, 6, 2, 6);
        adminMessagesNewMessagePanel.add(adminMessagesTitleTextField, gridBagConstraints);

        adminMessagesTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        adminMessagesTitleLabel.setText("Title");
        adminMessagesTitleLabel.setMaximumSize(new java.awt.Dimension(80, 25));
        adminMessagesTitleLabel.setMinimumSize(new java.awt.Dimension(80, 25));
        adminMessagesTitleLabel.setPreferredSize(new java.awt.Dimension(80, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(2, 6, 2, 6);
        adminMessagesNewMessagePanel.add(adminMessagesTitleLabel, gridBagConstraints);

        adminMessagesBodyPanel.add(adminMessagesNewMessagePanel, "card3");

        adminMessagesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"27 Jul 11:42", "Jakub Żmudaaaaa", "Karny kutas za nic"}
            },
            new String [] {
                "Date", "Name", "Topic"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        adminMessagesScrollPanel.setViewportView(adminMessagesTable);

        adminMessagesBodyPanel.add(adminMessagesScrollPanel, "card2");

        javax.swing.GroupLayout adminMessagesPanelLayout = new javax.swing.GroupLayout(adminMessagesPanel);
        adminMessagesPanel.setLayout(adminMessagesPanelLayout);
        adminMessagesPanelLayout.setHorizontalGroup(
            adminMessagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminMessagesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(adminMessagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(adminMessagesBodyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(adminMessagesHeadPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        adminMessagesPanelLayout.setVerticalGroup(
            adminMessagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminMessagesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(adminMessagesHeadPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adminMessagesBodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addContainerGap())
        );

        adminMainPanel.add(adminMessagesPanel, "card2");

        adminTeamsHeadPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        adminTeamsHeadPanel.setLayout(new java.awt.GridBagLayout());

        adminTeamsOverviewButton.setText("Overview");
        adminTeamsOverviewButton.setEnabled(false);
        adminTeamsOverviewButton.setMaximumSize(new java.awt.Dimension(100, 35));
        adminTeamsOverviewButton.setMinimumSize(new java.awt.Dimension(100, 35));
        adminTeamsOverviewButton.setPreferredSize(new java.awt.Dimension(100, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(7, 12, 7, 12);
        adminTeamsHeadPanel.add(adminTeamsOverviewButton, gridBagConstraints);

        adminTeamsCreateButton.setText("Create team");
        adminTeamsCreateButton.setMaximumSize(new java.awt.Dimension(100, 35));
        adminTeamsCreateButton.setMinimumSize(new java.awt.Dimension(100, 35));
        adminTeamsCreateButton.setPreferredSize(new java.awt.Dimension(100, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(7, 12, 7, 12);
        adminTeamsHeadPanel.add(adminTeamsCreateButton, gridBagConstraints);

        adminTeamsBodyPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        adminTeamsBodyPanel.setLayout(new java.awt.CardLayout());

        adminTeamsCreatePanel.setLayout(new java.awt.GridBagLayout());

        adminTeamsNameLabel.setText("Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(24, 6, 24, 6);
        adminTeamsCreatePanel.add(adminTeamsNameLabel, gridBagConstraints);

        adminTeamsTechnologyLabel.setText("Technology");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(24, 6, 24, 6);
        adminTeamsCreatePanel.add(adminTeamsTechnologyLabel, gridBagConstraints);

        adminTeamsNameTextField.setMaximumSize(new java.awt.Dimension(100, 35));
        adminTeamsNameTextField.setMinimumSize(new java.awt.Dimension(100, 35));
        adminTeamsNameTextField.setPreferredSize(new java.awt.Dimension(100, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(24, 6, 24, 6);
        adminTeamsCreatePanel.add(adminTeamsNameTextField, gridBagConstraints);

        adminTeamsTechnologyComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Java", "C#", "C++", "PHP", "RoR" }));
        adminTeamsTechnologyComboBox.setMaximumSize(new java.awt.Dimension(100, 35));
        adminTeamsTechnologyComboBox.setMinimumSize(new java.awt.Dimension(100, 35));
        adminTeamsTechnologyComboBox.setPreferredSize(new java.awt.Dimension(100, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(24, 6, 24, 6);
        adminTeamsCreatePanel.add(adminTeamsTechnologyComboBox, gridBagConstraints);

        adminTeamsBodyPanel.add(adminTeamsCreatePanel, "card3");

        adminTeamsOverviewPanel.setMaximumSize(new java.awt.Dimension(333, 287));
        adminTeamsOverviewPanel.setMinimumSize(new java.awt.Dimension(333, 287));
        adminTeamsOverviewPanel.setPreferredSize(new java.awt.Dimension(333, 287));

        adminTeamsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Team name", "Technology", "Members"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        adminTeamsOverviewPanel.setViewportView(adminTeamsTable);

        adminTeamsBodyPanel.add(adminTeamsOverviewPanel, "card2");

        javax.swing.GroupLayout adminTeamsPanelLayout = new javax.swing.GroupLayout(adminTeamsPanel);
        adminTeamsPanel.setLayout(adminTeamsPanelLayout);
        adminTeamsPanelLayout.setHorizontalGroup(
            adminTeamsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminTeamsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(adminTeamsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(adminTeamsBodyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(adminTeamsHeadPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        adminTeamsPanelLayout.setVerticalGroup(
            adminTeamsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminTeamsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(adminTeamsHeadPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adminTeamsBodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        adminMainPanel.add(adminTeamsPanel, "card2");

        adminEmployeesHeadPanel.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Technology");
        adminEmployeesHeadPanel.add(jLabel1, new java.awt.GridBagConstraints());

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Java", "C#", "C++", "PHP", "RoR" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        adminEmployeesHeadPanel.add(jComboBox1, new java.awt.GridBagConstraints());

        adminEmployeesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "First name", "Last name", "Experience", "Salary", "Team"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        adminEmployeesTablePanel.setViewportView(adminEmployeesTable);
        if (adminEmployeesTable.getColumnModel().getColumnCount() > 0) {
            adminEmployeesTable.getColumnModel().getColumn(0).setResizable(false);
            adminEmployeesTable.getColumnModel().getColumn(4).setResizable(false);
        }

        adminEmployeesSummaryPanel.setLayout(new java.awt.GridBagLayout());

        employeesAmountLabel.setText("12");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(7, 18, 7, 18);
        adminEmployeesSummaryPanel.add(employeesAmountLabel, gridBagConstraints);

        employeesExperienceLabel.setText("developers");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(7, 18, 7, 18);
        adminEmployeesSummaryPanel.add(employeesExperienceLabel, gridBagConstraints);

        employeesJuniorAmountLabel.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(7, 18, 7, 18);
        adminEmployeesSummaryPanel.add(employeesJuniorAmountLabel, gridBagConstraints);

        employeesExperienceJuniorLabel.setText("juniors");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(7, 18, 7, 18);
        adminEmployeesSummaryPanel.add(employeesExperienceJuniorLabel, gridBagConstraints);

        employeesRegularAmountLabel.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(7, 18, 7, 18);
        adminEmployeesSummaryPanel.add(employeesRegularAmountLabel, gridBagConstraints);

        employeesExperienceRegularLabel.setText("regulars");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(7, 18, 7, 18);
        adminEmployeesSummaryPanel.add(employeesExperienceRegularLabel, gridBagConstraints);

        employeesSeniorAmountLabel.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(7, 18, 7, 18);
        adminEmployeesSummaryPanel.add(employeesSeniorAmountLabel, gridBagConstraints);

        employeesExperienceSerniorLabel.setText("seniors");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(7, 18, 7, 18);
        adminEmployeesSummaryPanel.add(employeesExperienceSerniorLabel, gridBagConstraints);

        employeesManagersAmountLabel.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(7, 18, 7, 18);
        adminEmployeesSummaryPanel.add(employeesManagersAmountLabel, gridBagConstraints);

        employeesExperienceManagersLabel.setText("managers");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(7, 18, 7, 18);
        adminEmployeesSummaryPanel.add(employeesExperienceManagersLabel, gridBagConstraints);

        amount.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        amount.setText("Amount");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(7, 18, 7, 18);
        adminEmployeesSummaryPanel.add(amount, gridBagConstraints);

        exp.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        exp.setText("Experience");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(7, 18, 7, 18);
        adminEmployeesSummaryPanel.add(exp, gridBagConstraints);

        charge.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        charge.setText("Charge");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(7, 18, 7, 18);
        adminEmployeesSummaryPanel.add(charge, gridBagConstraints);

        average.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        average.setText("Average");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(7, 18, 7, 18);
        adminEmployeesSummaryPanel.add(average, gridBagConstraints);

        juniorsChargeLabel.setText("000000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(7, 18, 7, 18);
        adminEmployeesSummaryPanel.add(juniorsChargeLabel, gridBagConstraints);

        regularsChargeLabel.setText("000000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(7, 18, 7, 18);
        adminEmployeesSummaryPanel.add(regularsChargeLabel, gridBagConstraints);

        seniorsChargeLabel.setText("000000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(7, 18, 7, 18);
        adminEmployeesSummaryPanel.add(seniorsChargeLabel, gridBagConstraints);

        managersChargeLabel.setText("000000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(7, 18, 7, 18);
        adminEmployeesSummaryPanel.add(managersChargeLabel, gridBagConstraints);

        chargeLabel.setText("000000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(7, 18, 7, 18);
        adminEmployeesSummaryPanel.add(chargeLabel, gridBagConstraints);

        juniorsAverageLabel.setText("000000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(7, 18, 7, 18);
        adminEmployeesSummaryPanel.add(juniorsAverageLabel, gridBagConstraints);

        regularsAverageLabel.setText("000000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(7, 18, 7, 18);
        adminEmployeesSummaryPanel.add(regularsAverageLabel, gridBagConstraints);

        seniorsAverageLabel.setText("000000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(7, 18, 7, 18);
        adminEmployeesSummaryPanel.add(seniorsAverageLabel, gridBagConstraints);

        managersAverageLabel.setText("000000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(7, 18, 7, 18);
        adminEmployeesSummaryPanel.add(managersAverageLabel, gridBagConstraints);

        averageLabel.setText("000000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(7, 18, 7, 18);
        adminEmployeesSummaryPanel.add(averageLabel, gridBagConstraints);

        javax.swing.GroupLayout adminEmployeesPanelLayout = new javax.swing.GroupLayout(adminEmployeesPanel);
        adminEmployeesPanel.setLayout(adminEmployeesPanelLayout);
        adminEmployeesPanelLayout.setHorizontalGroup(
            adminEmployeesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminEmployeesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(adminEmployeesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(adminEmployeesSummaryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(adminEmployeesHeadPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(adminEmployeesTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        adminEmployeesPanelLayout.setVerticalGroup(
            adminEmployeesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminEmployeesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(adminEmployeesHeadPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adminEmployeesTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adminEmployeesSummaryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        adminMainPanel.add(adminEmployeesPanel, "card2");

        adminAppliesHeadPanel.setLayout(new java.awt.GridBagLayout());

        adminAppliesLabel.setText("16");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 5);
        adminAppliesHeadPanel.add(adminAppliesLabel, gridBagConstraints);

        adminAppliesLabel2.setText("new applies");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 5);
        adminAppliesHeadPanel.add(adminAppliesLabel2, gridBagConstraints);

        adminAppliesDecisionPanel.setPreferredSize(new java.awt.Dimension(100, 25));
        adminAppliesDecisionPanel.setLayout(new java.awt.GridBagLayout());

        adminAppliesHireButton.setText("Hire");
        adminAppliesHireButton.setMaximumSize(new java.awt.Dimension(100, 50));
        adminAppliesHireButton.setMinimumSize(new java.awt.Dimension(100, 50));
        adminAppliesHireButton.setPreferredSize(new java.awt.Dimension(100, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        adminAppliesDecisionPanel.add(adminAppliesHireButton, gridBagConstraints);

        adminAppliesRejectButton.setText("Reject");
        adminAppliesRejectButton.setMaximumSize(new java.awt.Dimension(100, 50));
        adminAppliesRejectButton.setMinimumSize(new java.awt.Dimension(100, 50));
        adminAppliesRejectButton.setPreferredSize(new java.awt.Dimension(100, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        adminAppliesDecisionPanel.add(adminAppliesRejectButton, gridBagConstraints);

        adminAppliesLaterButton.setText("Later");
        adminAppliesLaterButton.setMaximumSize(new java.awt.Dimension(100, 50));
        adminAppliesLaterButton.setMinimumSize(new java.awt.Dimension(100, 50));
        adminAppliesLaterButton.setPreferredSize(new java.awt.Dimension(100, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        adminAppliesDecisionPanel.add(adminAppliesLaterButton, gridBagConstraints);

        adminAppliesApplyPanel.setLayout(new java.awt.GridBagLayout());

        adminAppliesNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adminAppliesNameLabel.setText("Jakub");
        adminAppliesNameLabel.setMaximumSize(new java.awt.Dimension(100, 25));
        adminAppliesNameLabel.setMinimumSize(new java.awt.Dimension(100, 25));
        adminAppliesNameLabel.setPreferredSize(new java.awt.Dimension(100, 25));
        adminAppliesApplyPanel.add(adminAppliesNameLabel, new java.awt.GridBagConstraints());

        adminAppliesLastNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adminAppliesLastNameLabel.setText("Żmuda");
        adminAppliesLastNameLabel.setMaximumSize(new java.awt.Dimension(100, 25));
        adminAppliesLastNameLabel.setMinimumSize(new java.awt.Dimension(100, 25));
        adminAppliesLastNameLabel.setPreferredSize(new java.awt.Dimension(100, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        adminAppliesApplyPanel.add(adminAppliesLastNameLabel, gridBagConstraints);

        adminAppliesExperienceLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adminAppliesExperienceLabel.setText("Junior");
        adminAppliesExperienceLabel.setMaximumSize(new java.awt.Dimension(100, 25));
        adminAppliesExperienceLabel.setMinimumSize(new java.awt.Dimension(100, 25));
        adminAppliesExperienceLabel.setPreferredSize(new java.awt.Dimension(100, 25));
        adminAppliesApplyPanel.add(adminAppliesExperienceLabel, new java.awt.GridBagConstraints());

        adminAppliesLanguageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adminAppliesLanguageLabel.setText("Java");
        adminAppliesLanguageLabel.setMaximumSize(new java.awt.Dimension(100, 25));
        adminAppliesLanguageLabel.setMinimumSize(new java.awt.Dimension(100, 25));
        adminAppliesLanguageLabel.setPreferredSize(new java.awt.Dimension(100, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        adminAppliesApplyPanel.add(adminAppliesLanguageLabel, gridBagConstraints);

        adminAppliesSalaryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adminAppliesSalaryLabel.setText("3400");
        adminAppliesSalaryLabel.setMaximumSize(new java.awt.Dimension(100, 25));
        adminAppliesSalaryLabel.setMinimumSize(new java.awt.Dimension(100, 25));
        adminAppliesSalaryLabel.setPreferredSize(new java.awt.Dimension(100, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        adminAppliesApplyPanel.add(adminAppliesSalaryLabel, gridBagConstraints);

        javax.swing.GroupLayout adminAppliesPanelLayout = new javax.swing.GroupLayout(adminAppliesPanel);
        adminAppliesPanel.setLayout(adminAppliesPanelLayout);
        adminAppliesPanelLayout.setHorizontalGroup(
            adminAppliesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminAppliesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(adminAppliesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(adminAppliesApplyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(adminAppliesDecisionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(adminAppliesHeadPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        adminAppliesPanelLayout.setVerticalGroup(
            adminAppliesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminAppliesPanelLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(adminAppliesHeadPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(adminAppliesApplyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adminAppliesDecisionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        adminMainPanel.add(adminAppliesPanel, "card2");

        javax.swing.GroupLayout AdminPanelLayout = new javax.swing.GroupLayout(AdminPanel);
        AdminPanel.setLayout(AdminPanelLayout);
        AdminPanelLayout.setHorizontalGroup(
            AdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(adminMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(AdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adminInfoPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adminMenuPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        AdminPanelLayout.setVerticalGroup(
            AdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AdminPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(adminMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(AdminPanelLayout.createSequentialGroup()
                        .addComponent(adminInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(adminMenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        mainPanel.add(AdminPanel, "card1");

        EmployeePanel.setName("card1"); // NOI18N
        EmployeePanel.setPreferredSize(new java.awt.Dimension(500, 400));

        emplInfoPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        emplInfoPanel.setMinimumSize(new java.awt.Dimension(170, 80));
        emplInfoPanel.setPreferredSize(new java.awt.Dimension(170, 80));
        emplInfoPanel.setLayout(new java.awt.GridBagLayout());

        emplFirstNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emplFirstNameLabel.setText("Jakub");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        emplInfoPanel.add(emplFirstNameLabel, gridBagConstraints);

        emplLastNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emplLastNameLabel.setText("Żmuda");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 8, 0);
        emplInfoPanel.add(emplLastNameLabel, gridBagConstraints);

        emplExperienceLabel.setForeground(new java.awt.Color(0, 102, 0));
        emplExperienceLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emplExperienceLabel.setText("Junior");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 8, 0);
        emplInfoPanel.add(emplExperienceLabel, gridBagConstraints);

        emplSalaryLabel.setForeground(new java.awt.Color(0, 102, 0));
        emplSalaryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emplSalaryLabel.setText("3500");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        emplInfoPanel.add(emplSalaryLabel, gridBagConstraints);

        emplLanguageLabel.setForeground(new java.awt.Color(102, 0, 0));
        emplLanguageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emplLanguageLabel.setText("Java");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        emplInfoPanel.add(emplLanguageLabel, gridBagConstraints);

        emplTeamLabel.setForeground(new java.awt.Color(102, 0, 0));
        emplTeamLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emplTeamLabel.setText("Team Alfa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        emplInfoPanel.add(emplTeamLabel, gridBagConstraints);

        emplMenuPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        emplMenuPanel.setLayout(new java.awt.GridBagLayout());

        emplTeamViewButton.setText("Team view");
        emplTeamViewButton.setEnabled(false);
        emplTeamViewButton.setMaximumSize(new java.awt.Dimension(125, 25));
        emplTeamViewButton.setMinimumSize(new java.awt.Dimension(125, 25));
        emplTeamViewButton.setPreferredSize(new java.awt.Dimension(125, 25));
        emplTeamViewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emplTeamViewButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 17;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.insets = new java.awt.Insets(9, 5, 9, 5);
        emplMenuPanel.add(emplTeamViewButton, gridBagConstraints);

        emplMessagesButton.setText("Messages");
        emplMessagesButton.setMaximumSize(new java.awt.Dimension(125, 25));
        emplMessagesButton.setMinimumSize(new java.awt.Dimension(125, 25));
        emplMessagesButton.setPreferredSize(new java.awt.Dimension(125, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 17;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.insets = new java.awt.Insets(9, 5, 9, 5);
        emplMenuPanel.add(emplMessagesButton, gridBagConstraints);

        emplAskForPromotionButton.setText("Ask for promotion");
        emplAskForPromotionButton.setMaximumSize(new java.awt.Dimension(125, 25));
        emplAskForPromotionButton.setMinimumSize(new java.awt.Dimension(125, 25));
        emplAskForPromotionButton.setPreferredSize(new java.awt.Dimension(125, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 17;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.insets = new java.awt.Insets(9, 5, 9, 5);
        emplMenuPanel.add(emplAskForPromotionButton, gridBagConstraints);

        emplChangePasswordButton.setText("Change password");
        emplChangePasswordButton.setMaximumSize(new java.awt.Dimension(125, 25));
        emplChangePasswordButton.setMinimumSize(new java.awt.Dimension(125, 25));
        emplChangePasswordButton.setPreferredSize(new java.awt.Dimension(125, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 17;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.insets = new java.awt.Insets(9, 5, 9, 5);
        emplMenuPanel.add(emplChangePasswordButton, gridBagConstraints);

        emplMainPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        emplMainPanel.setPreferredSize(new java.awt.Dimension(400, 417));
        emplMainPanel.setLayout(new java.awt.CardLayout());

        emplMessagesPanel.setPreferredSize(new java.awt.Dimension(283, 300));

        emplMessagesHeadPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        emplMessagesHeadPanel.setLayout(new java.awt.GridBagLayout());

        emplMessagesMailBoxButton.setText("Mail box");
        emplMessagesMailBoxButton.setMaximumSize(new java.awt.Dimension(110, 35));
        emplMessagesMailBoxButton.setMinimumSize(new java.awt.Dimension(110, 35));
        emplMessagesMailBoxButton.setPreferredSize(new java.awt.Dimension(110, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 24, 10, 24);
        emplMessagesHeadPanel.add(emplMessagesMailBoxButton, gridBagConstraints);

        emplMessagesNewMessageButton.setText("New Message");
        emplMessagesNewMessageButton.setEnabled(false);
        emplMessagesNewMessageButton.setMaximumSize(new java.awt.Dimension(110, 35));
        emplMessagesNewMessageButton.setMinimumSize(new java.awt.Dimension(110, 35));
        emplMessagesNewMessageButton.setPreferredSize(new java.awt.Dimension(110, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 24, 10, 24);
        emplMessagesHeadPanel.add(emplMessagesNewMessageButton, gridBagConstraints);

        emplMessagesBodyPanel.setLayout(new java.awt.CardLayout());

        emplMessagesNewMessagePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        emplMessagesNewMessagePanel.setLayout(new java.awt.GridBagLayout());

        emplMessagesTypeLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        emplMessagesTypeLabel.setText("Type");
        emplMessagesTypeLabel.setMaximumSize(new java.awt.Dimension(80, 25));
        emplMessagesTypeLabel.setMinimumSize(new java.awt.Dimension(80, 25));
        emplMessagesTypeLabel.setPreferredSize(new java.awt.Dimension(80, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(2, 6, 2, 6);
        emplMessagesNewMessagePanel.add(emplMessagesTypeLabel, gridBagConstraints);

        emplMessagesTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Team mate", "Administrator" }));
        emplMessagesTypeComboBox.setMaximumSize(new java.awt.Dimension(160, 25));
        emplMessagesTypeComboBox.setMinimumSize(new java.awt.Dimension(160, 25));
        emplMessagesTypeComboBox.setPreferredSize(new java.awt.Dimension(160, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(2, 6, 2, 6);
        emplMessagesNewMessagePanel.add(emplMessagesTypeComboBox, gridBagConstraints);

        emplMessagesToLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        emplMessagesToLabel.setText("To");
        emplMessagesToLabel.setMaximumSize(new java.awt.Dimension(80, 25));
        emplMessagesToLabel.setMinimumSize(new java.awt.Dimension(80, 25));
        emplMessagesToLabel.setPreferredSize(new java.awt.Dimension(80, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(2, 6, 2, 6);
        emplMessagesNewMessagePanel.add(emplMessagesToLabel, gridBagConstraints);

        emplMessagesToComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Kuba", "Jakub", "Jakces", " " }));
        emplMessagesToComboBox.setMaximumSize(new java.awt.Dimension(160, 25));
        emplMessagesToComboBox.setMinimumSize(new java.awt.Dimension(160, 25));
        emplMessagesToComboBox.setPreferredSize(new java.awt.Dimension(160, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(2, 6, 2, 6);
        emplMessagesNewMessagePanel.add(emplMessagesToComboBox, gridBagConstraints);

        emplMessagesMessageTextArea.setColumns(20);
        emplMessagesMessageTextArea.setRows(5);
        emplMessagesTextPanel.setViewportView(emplMessagesMessageTextArea);
        emplMessagesMessageTextArea.setLineWrap(true);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 7;
        gridBagConstraints.insets = new java.awt.Insets(11, 11, 11, 11);
        emplMessagesNewMessagePanel.add(emplMessagesTextPanel, gridBagConstraints);

        emplMessagesTitleTextField.setMaximumSize(new java.awt.Dimension(160, 25));
        emplMessagesTitleTextField.setMinimumSize(new java.awt.Dimension(160, 25));
        emplMessagesTitleTextField.setPreferredSize(new java.awt.Dimension(160, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(2, 6, 2, 6);
        emplMessagesNewMessagePanel.add(emplMessagesTitleTextField, gridBagConstraints);

        emplMessagesTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        emplMessagesTitleLabel.setText("Title");
        emplMessagesTitleLabel.setMaximumSize(new java.awt.Dimension(80, 25));
        emplMessagesTitleLabel.setMinimumSize(new java.awt.Dimension(80, 25));
        emplMessagesTitleLabel.setPreferredSize(new java.awt.Dimension(80, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(2, 6, 2, 6);
        emplMessagesNewMessagePanel.add(emplMessagesTitleLabel, gridBagConstraints);

        emplMessagesBodyPanel.add(emplMessagesNewMessagePanel, "card3");

        emplMessagesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"27 Jul 11:42", "Jakub Żmudaaaaa", "Karny kutas za nic"}
            },
            new String [] {
                "Date", "Name", "Topic"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        emplMessagesScrollPanel.setViewportView(emplMessagesTable);

        emplMessagesBodyPanel.add(emplMessagesScrollPanel, "card2");

        javax.swing.GroupLayout emplMessagesPanelLayout = new javax.swing.GroupLayout(emplMessagesPanel);
        emplMessagesPanel.setLayout(emplMessagesPanelLayout);
        emplMessagesPanelLayout.setHorizontalGroup(
            emplMessagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, emplMessagesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(emplMessagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(emplMessagesBodyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(emplMessagesHeadPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        emplMessagesPanelLayout.setVerticalGroup(
            emplMessagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emplMessagesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(emplMessagesHeadPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emplMessagesBodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addContainerGap())
        );

        emplMainPanel.add(emplMessagesPanel, "card2");

        emplChangePasswordPanel.setLayout(new java.awt.GridBagLayout());

        emplCurrentPasswordLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        emplCurrentPasswordLabel.setText("current password");
        emplCurrentPasswordLabel.setMaximumSize(new java.awt.Dimension(120, 25));
        emplCurrentPasswordLabel.setMinimumSize(new java.awt.Dimension(120, 25));
        emplCurrentPasswordLabel.setPreferredSize(new java.awt.Dimension(120, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(11, 11, 11, 11);
        emplChangePasswordPanel.add(emplCurrentPasswordLabel, gridBagConstraints);

        emplNewPasswordLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        emplNewPasswordLabel.setText("new password");
        emplNewPasswordLabel.setMaximumSize(new java.awt.Dimension(120, 25));
        emplNewPasswordLabel.setMinimumSize(new java.awt.Dimension(120, 25));
        emplNewPasswordLabel.setPreferredSize(new java.awt.Dimension(120, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(11, 11, 11, 11);
        emplChangePasswordPanel.add(emplNewPasswordLabel, gridBagConstraints);

        emplConfirmLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        emplConfirmLabel.setText("confirm");
        emplConfirmLabel.setMaximumSize(new java.awt.Dimension(120, 25));
        emplConfirmLabel.setMinimumSize(new java.awt.Dimension(120, 25));
        emplConfirmLabel.setPreferredSize(new java.awt.Dimension(120, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(11, 11, 11, 11);
        emplChangePasswordPanel.add(emplConfirmLabel, gridBagConstraints);

        jPasswordField1.setMaximumSize(new java.awt.Dimension(120, 25));
        jPasswordField1.setMinimumSize(new java.awt.Dimension(120, 25));
        jPasswordField1.setPreferredSize(new java.awt.Dimension(120, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(11, 11, 11, 11);
        emplChangePasswordPanel.add(jPasswordField1, gridBagConstraints);

        jPasswordField2.setMaximumSize(new java.awt.Dimension(120, 25));
        jPasswordField2.setMinimumSize(new java.awt.Dimension(120, 25));
        jPasswordField2.setPreferredSize(new java.awt.Dimension(120, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(11, 11, 11, 11);
        emplChangePasswordPanel.add(jPasswordField2, gridBagConstraints);

        jPasswordField3.setMaximumSize(new java.awt.Dimension(120, 25));
        jPasswordField3.setMinimumSize(new java.awt.Dimension(120, 25));
        jPasswordField3.setPreferredSize(new java.awt.Dimension(120, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(11, 11, 11, 11);
        emplChangePasswordPanel.add(jPasswordField3, gridBagConstraints);

        emplSubmitChangePasswordButton.setText("Submit");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(11, 11, 11, 11);
        emplChangePasswordPanel.add(emplSubmitChangePasswordButton, gridBagConstraints);

        emplMainPanel.add(emplChangePasswordPanel, "card5");

        emplAskForPromotionPanel.setLayout(new java.awt.GridBagLayout());

        emplAskSalaryChangeCheckBox.setSelected(true);
        emplAskSalaryChangeCheckBox.setText("Update salary");
        emplAskSalaryChangeCheckBox.setMaximumSize(new java.awt.Dimension(120, 25));
        emplAskSalaryChangeCheckBox.setMinimumSize(new java.awt.Dimension(120, 25));
        emplAskSalaryChangeCheckBox.setPreferredSize(new java.awt.Dimension(120, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(13, 13, 13, 13);
        emplAskForPromotionPanel.add(emplAskSalaryChangeCheckBox, gridBagConstraints);

        emplAskExperienceChangeCheckBox.setText("Update experience");
        emplAskExperienceChangeCheckBox.setMaximumSize(new java.awt.Dimension(120, 25));
        emplAskExperienceChangeCheckBox.setMinimumSize(new java.awt.Dimension(120, 25));
        emplAskExperienceChangeCheckBox.setPreferredSize(new java.awt.Dimension(120, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(13, 13, 13, 13);
        emplAskForPromotionPanel.add(emplAskExperienceChangeCheckBox, gridBagConstraints);

        emplAskSalaryTextField.setMaximumSize(new java.awt.Dimension(120, 25));
        emplAskSalaryTextField.setMinimumSize(new java.awt.Dimension(120, 25));
        emplAskSalaryTextField.setPreferredSize(new java.awt.Dimension(120, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(13, 13, 13, 13);
        emplAskForPromotionPanel.add(emplAskSalaryTextField, gridBagConstraints);

        emplAskExperienceComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Junior", "Middle", "Senior", "Manager" }));
        emplAskExperienceComboBox.setMaximumSize(new java.awt.Dimension(120, 25));
        emplAskExperienceComboBox.setMinimumSize(new java.awt.Dimension(120, 25));
        emplAskExperienceComboBox.setPreferredSize(new java.awt.Dimension(120, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(13, 13, 13, 13);
        emplAskForPromotionPanel.add(emplAskExperienceComboBox, gridBagConstraints);

        emplAskSubmitButton.setText("Submit");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(13, 13, 13, 13);
        emplAskForPromotionPanel.add(emplAskSubmitButton, gridBagConstraints);

        emplMainPanel.add(emplAskForPromotionPanel, "card4");

        emplTeamViewPanel.setPreferredSize(new java.awt.Dimension(283, 300));

        emplTeamViewLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        emplTeamViewLabel.setForeground(new java.awt.Color(153, 0, 51));
        emplTeamViewLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emplTeamViewLabel.setText("Team Alfa");

        emplTeamTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Jakub", "Żmuda", "Junior"},
                {"Jan", "Kowalski", "Manager"}
            },
            new String [] {
                "First name", "Last Name", "Experience"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        emplScrollPanel.setViewportView(emplTeamTable);
        if (emplTeamTable.getColumnModel().getColumnCount() > 0) {
            emplTeamTable.getColumnModel().getColumn(0).setResizable(false);
            emplTeamTable.getColumnModel().getColumn(1).setResizable(false);
            emplTeamTable.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout emplTeamViewPanelLayout = new javax.swing.GroupLayout(emplTeamViewPanel);
        emplTeamViewPanel.setLayout(emplTeamViewPanelLayout);
        emplTeamViewPanelLayout.setHorizontalGroup(
            emplTeamViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emplTeamViewPanelLayout.createSequentialGroup()
                .addContainerGap(160, Short.MAX_VALUE)
                .addComponent(emplTeamViewLabel)
                .addGap(103, 103, 103))
            .addComponent(emplScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        emplTeamViewPanelLayout.setVerticalGroup(
            emplTeamViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emplTeamViewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(emplTeamViewLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emplScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
        );

        emplMainPanel.add(emplTeamViewPanel, "card2");

        javax.swing.GroupLayout EmployeePanelLayout = new javax.swing.GroupLayout(EmployeePanel);
        EmployeePanel.setLayout(EmployeePanelLayout);
        EmployeePanelLayout.setHorizontalGroup(
            EmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EmployeePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(emplMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(emplInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(emplMenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        EmployeePanelLayout.setVerticalGroup(
            EmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EmployeePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emplMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(EmployeePanelLayout.createSequentialGroup()
                        .addComponent(emplInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emplMenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)))
                .addContainerGap())
        );

        mainPanel.add(EmployeePanel, "card1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginConnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginConnectButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginConnectButtonActionPerformed

    private void loginUserFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginUserFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginUserFieldActionPerformed

    private void applyApplyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyApplyButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_applyApplyButtonActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        signInButton.setEnabled(true);
        registerButton.setEnabled(false);
        connectBodyLayout.show(connectBodyPanel, "applyCard");
    }//GEN-LAST:event_registerButtonActionPerformed

    private void signInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInButtonActionPerformed
        signInButton.setEnabled(false);
        registerButton.setEnabled(true);
        connectBodyLayout.show(connectBodyPanel, "loginCard");
    }//GEN-LAST:event_signInButtonActionPerformed

    private void applyLanguageComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyLanguageComboBoxActionPerformed
        System.out.println("Change");
    }//GEN-LAST:event_applyLanguageComboBoxActionPerformed

    private void emplTeamViewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emplTeamViewButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emplTeamViewButtonActionPerformed

    private void adminMenuEmployeeAppliesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminMenuEmployeeAppliesButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adminMenuEmployeeAppliesButtonActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AdminPanel;
    private javax.swing.JPanel EmployeePanel;
    private javax.swing.JPanel adminAppliesApplyPanel;
    private javax.swing.JPanel adminAppliesDecisionPanel;
    private javax.swing.JLabel adminAppliesExperienceLabel;
    private javax.swing.JPanel adminAppliesHeadPanel;
    private javax.swing.JButton adminAppliesHireButton;
    private javax.swing.JLabel adminAppliesLabel;
    private javax.swing.JLabel adminAppliesLabel2;
    private javax.swing.JLabel adminAppliesLanguageLabel;
    private javax.swing.JLabel adminAppliesLastNameLabel;
    private javax.swing.JButton adminAppliesLaterButton;
    private javax.swing.JLabel adminAppliesNameLabel;
    private javax.swing.JPanel adminAppliesPanel;
    private javax.swing.JButton adminAppliesRejectButton;
    private javax.swing.JLabel adminAppliesSalaryLabel;
    private javax.swing.JPanel adminEmployeesHeadPanel;
    private javax.swing.JPanel adminEmployeesPanel;
    private javax.swing.JPanel adminEmployeesSummaryPanel;
    private javax.swing.JTable adminEmployeesTable;
    private javax.swing.JScrollPane adminEmployeesTablePanel;
    private javax.swing.JLabel adminInfoLabel;
    private javax.swing.JPanel adminInfoPanel;
    private javax.swing.JPanel adminMainPanel;
    private javax.swing.JButton adminMenuEmployeeAppliesButton;
    private javax.swing.JButton adminMenuEmployeesManagerButton;
    private javax.swing.JButton adminMenuMessagesButton;
    private javax.swing.JPanel adminMenuPanel;
    private javax.swing.JButton adminMenuTeamListButton;
    private javax.swing.JPanel adminMessagesBodyPanel;
    private javax.swing.JPanel adminMessagesHeadPanel;
    private javax.swing.JButton adminMessagesMailBoxButton;
    private javax.swing.JTextArea adminMessagesMessageTextArea;
    private javax.swing.JButton adminMessagesNewMessageButton;
    private javax.swing.JPanel adminMessagesNewMessagePanel;
    private javax.swing.JPanel adminMessagesPanel;
    private javax.swing.JScrollPane adminMessagesScrollPanel;
    private javax.swing.JTable adminMessagesTable;
    private javax.swing.JScrollPane adminMessagesTextPanel;
    private javax.swing.JLabel adminMessagesTitleLabel;
    private javax.swing.JTextField adminMessagesTitleTextField;
    private javax.swing.JComboBox adminMessagesToComboBox;
    private javax.swing.JLabel adminMessagesToLabel;
    private javax.swing.JComboBox adminMessagesTypeComboBox;
    private javax.swing.JLabel adminMessagesTypeLabel;
    private javax.swing.JPanel adminTeamsBodyPanel;
    private javax.swing.JButton adminTeamsCreateButton;
    private javax.swing.JPanel adminTeamsCreatePanel;
    private javax.swing.JPanel adminTeamsHeadPanel;
    private javax.swing.JLabel adminTeamsNameLabel;
    private javax.swing.JTextField adminTeamsNameTextField;
    private javax.swing.JButton adminTeamsOverviewButton;
    private javax.swing.JScrollPane adminTeamsOverviewPanel;
    private javax.swing.JPanel adminTeamsPanel;
    private javax.swing.JTable adminTeamsTable;
    private javax.swing.JComboBox adminTeamsTechnologyComboBox;
    private javax.swing.JLabel adminTeamsTechnologyLabel;
    private javax.swing.JLabel amount;
    private javax.swing.JButton applyApplyButton;
    private javax.swing.JTextField applyFirstNameField;
    private javax.swing.JLabel applyFirstNameLabel;
    private javax.swing.JComboBox applyLanguageComboBox;
    private javax.swing.JLabel applyLanguageLabel;
    private javax.swing.JTextField applyLastNameField;
    private javax.swing.JLabel applyLastNameLabel;
    private javax.swing.JPanel applyPanel;
    private javax.swing.JPasswordField applyPassword2Field;
    private javax.swing.JLabel applyPassword2Label;
    private javax.swing.JPasswordField applyPasswordField;
    private javax.swing.JLabel applyPasswordLabel;
    private javax.swing.JTextField applySalaryField;
    private javax.swing.JLabel applySalaryLabel;
    private javax.swing.JTextField applyUserField;
    private javax.swing.JLabel applyUserLabel;
    private javax.swing.JLabel average;
    private javax.swing.JLabel averageLabel;
    private javax.swing.JLabel charge;
    private javax.swing.JLabel chargeLabel;
    private javax.swing.JPanel connectBodyPanel;
    private javax.swing.JPanel connectHeadPanel;
    private javax.swing.JPanel connectPanel;
    private javax.swing.JCheckBox emplAskExperienceChangeCheckBox;
    private javax.swing.JComboBox emplAskExperienceComboBox;
    private javax.swing.JButton emplAskForPromotionButton;
    private javax.swing.JPanel emplAskForPromotionPanel;
    private javax.swing.JCheckBox emplAskSalaryChangeCheckBox;
    private javax.swing.JTextField emplAskSalaryTextField;
    private javax.swing.JButton emplAskSubmitButton;
    private javax.swing.JButton emplChangePasswordButton;
    private javax.swing.JPanel emplChangePasswordPanel;
    private javax.swing.JLabel emplConfirmLabel;
    private javax.swing.JLabel emplCurrentPasswordLabel;
    private javax.swing.JLabel emplExperienceLabel;
    private javax.swing.JLabel emplFirstNameLabel;
    private javax.swing.JPanel emplInfoPanel;
    private javax.swing.JLabel emplLanguageLabel;
    private javax.swing.JLabel emplLastNameLabel;
    private javax.swing.JPanel emplMainPanel;
    private javax.swing.JPanel emplMenuPanel;
    private javax.swing.JPanel emplMessagesBodyPanel;
    private javax.swing.JButton emplMessagesButton;
    private javax.swing.JPanel emplMessagesHeadPanel;
    private javax.swing.JButton emplMessagesMailBoxButton;
    private javax.swing.JTextArea emplMessagesMessageTextArea;
    private javax.swing.JButton emplMessagesNewMessageButton;
    private javax.swing.JPanel emplMessagesNewMessagePanel;
    private javax.swing.JPanel emplMessagesPanel;
    private javax.swing.JScrollPane emplMessagesScrollPanel;
    private javax.swing.JTable emplMessagesTable;
    private javax.swing.JScrollPane emplMessagesTextPanel;
    private javax.swing.JLabel emplMessagesTitleLabel;
    private javax.swing.JTextField emplMessagesTitleTextField;
    private javax.swing.JComboBox emplMessagesToComboBox;
    private javax.swing.JLabel emplMessagesToLabel;
    private javax.swing.JComboBox emplMessagesTypeComboBox;
    private javax.swing.JLabel emplMessagesTypeLabel;
    private javax.swing.JLabel emplNewPasswordLabel;
    private javax.swing.JLabel emplSalaryLabel;
    private javax.swing.JScrollPane emplScrollPanel;
    private javax.swing.JButton emplSubmitChangePasswordButton;
    private javax.swing.JLabel emplTeamLabel;
    private javax.swing.JTable emplTeamTable;
    private javax.swing.JButton emplTeamViewButton;
    private javax.swing.JLabel emplTeamViewLabel;
    private javax.swing.JPanel emplTeamViewPanel;
    private javax.swing.JLabel employeesAmountLabel;
    private javax.swing.JLabel employeesExperienceJuniorLabel;
    private javax.swing.JLabel employeesExperienceLabel;
    private javax.swing.JLabel employeesExperienceManagersLabel;
    private javax.swing.JLabel employeesExperienceRegularLabel;
    private javax.swing.JLabel employeesExperienceSerniorLabel;
    private javax.swing.JLabel employeesJuniorAmountLabel;
    private javax.swing.JLabel employeesManagersAmountLabel;
    private javax.swing.JLabel employeesRegularAmountLabel;
    private javax.swing.JLabel employeesSeniorAmountLabel;
    private javax.swing.JLabel exp;
    private javax.swing.JComboBox experienceComboBox;
    private javax.swing.JLabel experienceLabel;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField jPasswordField3;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JLabel juniorsAverageLabel;
    private javax.swing.JLabel juniorsChargeLabel;
    private javax.swing.JButton loginConnectButton;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JPasswordField loginPasswordField;
    private javax.swing.JLabel loginPasswordLabel;
    private javax.swing.JTextField loginUserField;
    private javax.swing.JLabel loginUserLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel managersAverageLabel;
    private javax.swing.JLabel managersChargeLabel;
    private javax.swing.JButton registerButton;
    private javax.swing.JLabel regularsAverageLabel;
    private javax.swing.JLabel regularsChargeLabel;
    private javax.swing.JLabel seniorsAverageLabel;
    private javax.swing.JLabel seniorsChargeLabel;
    private javax.swing.JButton signInButton;
    // End of variables declaration//GEN-END:variables
}
