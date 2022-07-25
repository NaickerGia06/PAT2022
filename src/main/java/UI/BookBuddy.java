/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BackendManagerClasses.BookManager;
import BackendManagerClasses.StudentManager;
import java.sql.Date;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gia Naicker
 */
public class BookBuddy extends javax.swing.JFrame {

    /**
     * Creates new form tabbedUI
     */
    StudentManager sm;
    BookManager bm;

    public BookBuddy() throws ClassNotFoundException, SQLException {
        initComponents();
        setLocationRelativeTo(null);
        this.bm = new BookManager();
        this.sm = new StudentManager();

        //BOOK MANAGER CLASS
        //populates GENRE COMBOBOX
        populateGenreComboBox();

        //populates BOOKS TABLE during runTime
        updatesBookTableInManageBooksScreen();

        //populates TABLE with book titles of books that have been borrowed
        populateReturnBooksTable();

        //populates borrowBooksTableWhenRun
        populateBorrowBooksTableOnRun();

        highestRatedBooksTextArea1.setText(bm.getHighestRatedBooks());

        //STUDENT MANAGER CLASS
        try { // make these into their own method later
            sm = new StudentManager();

            DefaultComboBoxModel filterGradeModel3 = new DefaultComboBoxModel();
            ArrayList<String> grades3 = sm.getGrades();
            filterGradeModel3.addAll(grades3);
            filterGradeComboBox.setModel(filterGradeModel3);

            //populates with student names (& surnames)
            DefaultComboBoxModel studentNameModel = new DefaultComboBoxModel();
            ArrayList<String> students = sm.getStudentsNames();
            studentNameModel.addAll(students);
            selectStudentComboBox.setModel(studentNameModel);

        } catch (ClassNotFoundException e) {

        } catch (SQLException e) {

        }

        //populates STUDENTS TABLE
        populateStudentsTable();

        setsReturnStudentComboBoxModel();

    }

    //BOOKS
    public void updatesBookTableInManageBooksScreen() throws ClassNotFoundException, SQLException {
        //Populates Book Table
        String[] coloumNamesForBooksTbl = new String[5];
        coloumNamesForBooksTbl[0] = "Title";
        coloumNamesForBooksTbl[1] = "Author";
        coloumNamesForBooksTbl[2] = "Genre";
        coloumNamesForBooksTbl[3] = "ISBN";
        coloumNamesForBooksTbl[4] = "Quantity";

        // gets data and populates table model, then sets table to table model
        Object[][] booksData = bm.makeManageBooksTable();
        DefaultTableModel booksModel = new DefaultTableModel(booksData, coloumNamesForBooksTbl);
        booksTable.setModel(booksModel);
    }

    public void populateBorrowBooksTableOnRun() throws ClassNotFoundException, SQLException {
        //Populates Book Table
        String[] coloumNamesForBorrowBooksTbl = new String[3];
        coloumNamesForBorrowBooksTbl[0] = "Title";
        coloumNamesForBorrowBooksTbl[1] = "Author";
        coloumNamesForBorrowBooksTbl[2] = "Quantity";

        // gets data and populates table model, then sets table to table model
        Object[][] booksData = bm.makeBorrowedBooksTable("");
        DefaultTableModel booksModel = new DefaultTableModel(booksData, coloumNamesForBorrowBooksTbl);
        borrowBooksTable.setModel(booksModel);
    }

    public void populateReturnBooksTable() throws ClassNotFoundException, SQLException {
        String[] coloumNamesForReturnBooksTbl = new String[2];
        coloumNamesForReturnBooksTbl[0] = "Title";
        coloumNamesForReturnBooksTbl[1] = "Author";

        // gets data and populates table model, then sets table to table model
        Object[][] returnBooksTableData = bm.makeReturnBooksTable();
        DefaultTableModel returnBooksModel = new DefaultTableModel(returnBooksTableData, coloumNamesForReturnBooksTbl);
        returnBooksTable.setModel(returnBooksModel);
    }

    public void populateGenreComboBox() throws ClassNotFoundException, SQLException {

        DefaultComboBoxModel comboModel = new DefaultComboBoxModel();
        ArrayList<String> genres = bm.getGenres();
        comboModel.addAll(genres);
    }

    //STUDENTS
    public void populateStudentsTable() throws ClassNotFoundException, SQLException {
        String[] coloumNamesForStudentTbl = new String[3];
        coloumNamesForStudentTbl[0] = "Name";
        coloumNamesForStudentTbl[1] = "Surname";
        coloumNamesForStudentTbl[2] = "Grade";

        // gets data and populates table model, then sets table to table model
        Object[][] studentData = sm.makeStudentTable();
        DefaultTableModel bookModel = new DefaultTableModel(studentData, coloumNamesForStudentTbl);
        studentsTable.setModel(bookModel);
    }

    public void setsReturnStudentComboBoxModel() throws ClassNotFoundException, SQLException {
        DefaultComboBoxModel studentReturnComboModel = new DefaultComboBoxModel();
        ArrayList<String> students = sm.populateReturnStudentComboBox();
        studentReturnComboModel.addAll(students);
        returnedByComboBox.setModel(studentReturnComboModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        filterByGradeLabel = new javax.swing.JLabel();
        dateBorrowedDatePicker = new com.github.lgooddatepicker.components.DatePicker();
        borrowBookLabel = new javax.swing.JLabel();
        markAsBorrowedButton = new javax.swing.JButton();
        availableBooksToBorrowLabel = new javax.swing.JLabel();
        filterGradeComboBox = new javax.swing.JComboBox<>();
        selectStudentLabel = new javax.swing.JLabel();
        selectStudentComboBox = new javax.swing.JComboBox<>();
        searchForBooksLabel = new javax.swing.JLabel();
        dateBorrowedLabel1 = new javax.swing.JLabel();
        dateBorrowedErrorMessageLabel = new javax.swing.JLabel();
        noticeLabel1 = new javax.swing.JLabel();
        noticeLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        borrowBooksTable = new javax.swing.JTable();
        searchTitleTextField = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        returnABookLabel = new javax.swing.JLabel();
        takenOutBooksLabel = new javax.swing.JLabel();
        dateReturnedLabel = new javax.swing.JLabel();
        returnedByLabel = new javax.swing.JLabel();
        dateReturnedDatePicker = new com.github.lgooddatepicker.components.DatePicker();
        amountOwedLabel = new javax.swing.JLabel();
        markAsReturnedButton = new javax.swing.JButton();
        amountOwedTextField = new javax.swing.JTextField();
        daysOverdueLabel = new javax.swing.JLabel();
        daysOverdueTextField = new javax.swing.JTextField();
        returnedByComboBox = new javax.swing.JComboBox<>();
        dateReturnedErrorMessage = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        returnBooksTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        manageBooksLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        booksTable = new javax.swing.JTable();
        editBookButton = new javax.swing.JButton();
        addBookButton = new javax.swing.JButton();
        deleteBookButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        manageStudentsLabel = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        studentsTable = new javax.swing.JTable();
        addStudentButton = new javax.swing.JButton();
        editStudentButton = new javax.swing.JButton();
        removeStudentButton = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        lookingForBooksLabel = new javax.swing.JLabel();
        weGotYouLabel = new javax.swing.JLabel();
        searchFavouriteBookTitleLabel = new javax.swing.JLabel();
        searchBookTitleTextField = new javax.swing.JTextField();
        commentsLabel = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        commentsTextArea = new javax.swing.JTextArea();
        searchGenreLabel = new javax.swing.JLabel();
        searchGenreComboBox = new javax.swing.JComboBox<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        exploreBooksTable = new javax.swing.JTable();
        searchFavouriteAuthorLabel = new javax.swing.JLabel();
        searchFavAuthorTextField = new javax.swing.JTextField();
        highestRatedBooksLabel1 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        highestRatedBooksTextArea1 = new javax.swing.JTextArea();
        jPanel9 = new javax.swing.JPanel();
        informationPageLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        informationTextArea = new javax.swing.JTextArea();
        manageBooksScreenButton = new javax.swing.JButton();
        manageStudentScreenButton = new javax.swing.JButton();
        borrowBookScreenButton = new javax.swing.JButton();
        returnBookScreenButton = new javax.swing.JButton();
        exploreScreenButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        filterByGradeLabel.setText("Filter by grade");
        filterByGradeLabel.setFont(new java.awt.Font("Impact", 0, 15)); // NOI18N
        filterByGradeLabel.setForeground(new java.awt.Color(0, 0, 0));

        borrowBookLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        borrowBookLabel.setText("Looking to borrow a book?");
        borrowBookLabel.setFont(new java.awt.Font("Impact", 0, 50)); // NOI18N
        borrowBookLabel.setForeground(new java.awt.Color(0, 0, 0));

        markAsBorrowedButton.setText("Mark as taken out");
        markAsBorrowedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                markAsBorrowedButtonActionPerformed(evt);
            }
        });

        availableBooksToBorrowLabel.setText("Please select a book to borrow:");
        availableBooksToBorrowLabel.setFont(new java.awt.Font("Impact", 0, 15)); // NOI18N
        availableBooksToBorrowLabel.setForeground(new java.awt.Color(0, 0, 0));

        filterGradeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        filterGradeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterGradeComboBoxActionPerformed(evt);
            }
        });

        selectStudentLabel.setText("Student's Name");
        selectStudentLabel.setFont(new java.awt.Font("Impact", 0, 15)); // NOI18N
        selectStudentLabel.setForeground(new java.awt.Color(0, 0, 0));

        selectStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        searchForBooksLabel.setText("Search for books:");
        searchForBooksLabel.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        searchForBooksLabel.setForeground(new java.awt.Color(0, 0, 0));

        dateBorrowedLabel1.setText("Date Borrowed");
        dateBorrowedLabel1.setFont(new java.awt.Font("Impact", 0, 15)); // NOI18N
        dateBorrowedLabel1.setForeground(new java.awt.Color(0, 0, 0));

        dateBorrowedErrorMessageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateBorrowedErrorMessageLabel.setForeground(new java.awt.Color(255, 51, 51));

        noticeLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        noticeLabel1.setText("Please note that you may only borrow a book");
        noticeLabel1.setFont(new java.awt.Font("Impact", 0, 15)); // NOI18N

        noticeLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        noticeLabel2.setText("for 2 weeks. Fines will be charged on overdue books.");
        noticeLabel2.setFont(new java.awt.Font("Impact", 0, 15)); // NOI18N

        borrowBooksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(borrowBooksTable);

        searchTitleTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTitleTextFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchTitleTextFieldKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(borrowBookLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(searchForBooksLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(15, 15, 15)
                                .addComponent(searchTitleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(availableBooksToBorrowLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(noticeLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(noticeLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(markAsBorrowedButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateBorrowedErrorMessageLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(filterByGradeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(selectStudentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dateBorrowedLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(selectStudentComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(filterGradeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(dateBorrowedDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(borrowBookLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(filterByGradeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filterGradeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(selectStudentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectStudentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dateBorrowedDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateBorrowedLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(dateBorrowedErrorMessageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(markAsBorrowedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(noticeLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(noticeLabel2))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(searchForBooksLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchTitleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(availableBooksToBorrowLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Borrow a book", jPanel4);

        returnABookLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        returnABookLabel.setText("Return a Book");
        returnABookLabel.setFont(new java.awt.Font("Impact", 0, 50)); // NOI18N
        returnABookLabel.setForeground(new java.awt.Color(0, 0, 0));

        takenOutBooksLabel.setText("Books that are currently taken out of the library");
        takenOutBooksLabel.setFont(new java.awt.Font("Impact", 0, 13)); // NOI18N
        takenOutBooksLabel.setForeground(new java.awt.Color(0, 0, 0));

        dateReturnedLabel.setText("Date returned:");
        dateReturnedLabel.setFont(new java.awt.Font("Impact", 0, 15)); // NOI18N
        dateReturnedLabel.setForeground(new java.awt.Color(0, 0, 0));

        returnedByLabel.setText("Returned by:");
        returnedByLabel.setFont(new java.awt.Font("Impact", 0, 15)); // NOI18N
        returnedByLabel.setForeground(new java.awt.Color(0, 0, 0));

        amountOwedLabel.setText("Outstanding amount:");
        amountOwedLabel.setFont(new java.awt.Font("Impact", 0, 15)); // NOI18N
        amountOwedLabel.setForeground(new java.awt.Color(0, 0, 0));

        markAsReturnedButton.setText("Mark as returned");
        markAsReturnedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                markAsReturnedButtonActionPerformed(evt);
            }
        });

        amountOwedTextField.setEditable(false);

        daysOverdueLabel.setText("Days overdue:");
        daysOverdueLabel.setFont(new java.awt.Font("Impact", 0, 15)); // NOI18N
        daysOverdueLabel.setForeground(new java.awt.Color(0, 0, 0));

        daysOverdueTextField.setEditable(false);

        returnedByComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        returnedByComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnedByComboBoxActionPerformed(evt);
            }
        });

        returnBooksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        returnBooksTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                returnBooksTableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(returnBooksTable);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(returnABookLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(408, 408, 408))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(takenOutBooksLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(amountOwedLabel)
                                            .addComponent(daysOverdueLabel)
                                            .addComponent(dateReturnedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(daysOverdueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(amountOwedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dateReturnedDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(markAsReturnedButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(returnedByLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(returnedByComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateReturnedErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(dateReturnedErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(returnABookLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(takenOutBooksLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(returnedByLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(returnedByComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(dateReturnedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateReturnedDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(daysOverdueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(daysOverdueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(amountOwedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(amountOwedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)
                                .addComponent(markAsReturnedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Return a book", jPanel8);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(322, 322, 322)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(44, 44, 44))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(jLabel6)
                .addGap(9, 9, 9)
                .addComponent(jLabel7)
                .addContainerGap(240, Short.MAX_VALUE))
        );

        manageBooksLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        manageBooksLabel.setText("Manage Books");
        manageBooksLabel.setFont(new java.awt.Font("Impact", 0, 50)); // NOI18N
        manageBooksLabel.setForeground(new java.awt.Color(0, 0, 0));

        booksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(booksTable);

        editBookButton.setText("Edit");
        editBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBookButtonActionPerformed(evt);
            }
        });

        addBookButton.setText("Add");
        addBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBookButtonActionPerformed(evt);
            }
        });

        deleteBookButton.setText("Delete");
        deleteBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBookButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(addBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(editBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(deleteBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(manageBooksLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 65, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(manageBooksLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manage books", jPanel2);

        manageStudentsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        manageStudentsLabel.setText("Manage Students");
        manageStudentsLabel.setFont(new java.awt.Font("Impact", 0, 50)); // NOI18N
        manageStudentsLabel.setForeground(new java.awt.Color(0, 0, 0));

        studentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane10.setViewportView(studentsTable);

        addStudentButton.setText("Add");
        addStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentButtonActionPerformed(evt);
            }
        });

        editStudentButton.setText("Edit");
        editStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editStudentButtonActionPerformed(evt);
            }
        });

        removeStudentButton.setText("Remove");
        removeStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeStudentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(editStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(removeStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addComponent(manageStudentsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(manageStudentsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manage Students", jPanel1);

        lookingForBooksLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lookingForBooksLabel.setText("Looking for similar books?");
        lookingForBooksLabel.setFont(new java.awt.Font("Impact", 0, 50)); // NOI18N
        lookingForBooksLabel.setForeground(new java.awt.Color(0, 0, 0));

        weGotYouLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        weGotYouLabel.setText("Don't worry, we've got you ;)");
        weGotYouLabel.setFont(new java.awt.Font("Impact", 0, 15)); // NOI18N
        weGotYouLabel.setForeground(new java.awt.Color(0, 0, 0));

        searchFavouriteBookTitleLabel.setText("Favourite book:");
        searchFavouriteBookTitleLabel.setBackground(new java.awt.Color(255, 255, 255));
        searchFavouriteBookTitleLabel.setFont(new java.awt.Font("Impact", 0, 15)); // NOI18N
        searchFavouriteBookTitleLabel.setForeground(new java.awt.Color(0, 0, 0));

        searchBookTitleTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchBookTitleTextFieldKeyReleased(evt);
            }
        });

        commentsLabel.setText("Comments:");
        commentsLabel.setFont(new java.awt.Font("Impact", 0, 15)); // NOI18N
        commentsLabel.setForeground(new java.awt.Color(0, 0, 0));

        commentsTextArea.setColumns(20);
        commentsTextArea.setEditable(false);
        commentsTextArea.setRows(5);
        jScrollPane6.setViewportView(commentsTextArea);

        searchGenreLabel.setText("Search  genres:");
        searchGenreLabel.setBackground(new java.awt.Color(255, 255, 255));
        searchGenreLabel.setFont(new java.awt.Font("Impact", 0, 15)); // NOI18N
        searchGenreLabel.setForeground(new java.awt.Color(0, 0, 0));

        searchGenreComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Romance", "Non-fiction", "Drama", "Mystery", "Fiction", "Science Fiction", "Biography / Autobiography", "Lifestyle", "Horror / Thriller", "Comedy" }));
        searchGenreComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchGenreComboBoxActionPerformed(evt);
            }
        });

        exploreBooksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title", "Author", "Genre", "Avg Rating", "Available Books"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        exploreBooksTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exploreBooksTableMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(exploreBooksTable);

        searchFavouriteAuthorLabel.setText("Search authors:");
        searchFavouriteAuthorLabel.setBackground(new java.awt.Color(255, 255, 255));
        searchFavouriteAuthorLabel.setFont(new java.awt.Font("Impact", 0, 15)); // NOI18N
        searchFavouriteAuthorLabel.setForeground(new java.awt.Color(0, 0, 0));

        searchFavAuthorTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFavAuthorTextFieldKeyReleased(evt);
            }
        });

        highestRatedBooksLabel1.setText("HIghest Rated Books:");
        highestRatedBooksLabel1.setFont(new java.awt.Font("Impact", 0, 15)); // NOI18N
        highestRatedBooksLabel1.setForeground(new java.awt.Color(0, 0, 0));

        highestRatedBooksTextArea1.setColumns(20);
        highestRatedBooksTextArea1.setEditable(false);
        highestRatedBooksTextArea1.setRows(5);
        jScrollPane12.setViewportView(highestRatedBooksTextArea1);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(weGotYouLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(searchFavouriteAuthorLabel)
                                            .addComponent(searchFavouriteBookTitleLabel))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(searchBookTitleTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                                            .addComponent(searchFavAuthorTextField)))
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(searchGenreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(searchGenreComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(28, 28, 28)))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(commentsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                            .addComponent(highestRatedBooksLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane12))
                        .addGap(26, 26, 26))
                    .addComponent(lookingForBooksLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lookingForBooksLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(commentsLabel)
                    .addComponent(weGotYouLabel))
                .addGap(11, 11, 11)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(highestRatedBooksLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane12))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchBookTitleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchFavouriteBookTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchFavouriteAuthorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchFavAuthorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchGenreComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchGenreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Explore", jPanel7);

        informationPageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        informationPageLabel.setText("Information Page / Help");
        informationPageLabel.setFont(new java.awt.Font("Impact", 0, 50)); // NOI18N
        informationPageLabel.setForeground(new java.awt.Color(0, 0, 0));

        informationTextArea.setColumns(20);
        informationTextArea.setEditable(false);
        informationTextArea.setRows(5);
        informationTextArea.setAutoscrolls(false);
        jScrollPane2.setViewportView(informationTextArea);

        manageBooksScreenButton.setText("Manage Books");
        manageBooksScreenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageBooksScreenButtonActionPerformed(evt);
            }
        });

        manageStudentScreenButton.setText("Manage Students");
        manageStudentScreenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageStudentScreenButtonActionPerformed(evt);
            }
        });

        borrowBookScreenButton.setText("Borrow A Book");
        borrowBookScreenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrowBookScreenButtonActionPerformed(evt);
            }
        });

        returnBookScreenButton.setText("Return A Book");
        returnBookScreenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBookScreenButtonActionPerformed(evt);
            }
        });

        exploreScreenButton.setText("Explore");
        exploreScreenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exploreScreenButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(manageBooksScreenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(manageStudentScreenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(borrowBookScreenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(returnBookScreenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(exploreScreenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(informationPageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE))
                .addGap(39, 39, 39))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(informationPageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(borrowBookScreenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(returnBookScreenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(manageBooksScreenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(manageStudentScreenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(exploreScreenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Need some help?", jPanel9);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 904, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void markAsBorrowedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_markAsBorrowedButtonActionPerformed

        try {

            String selectedBookValue = (String) borrowBooksTable.getModel().getValueAt(borrowBooksTable.getSelectedRow(), borrowBooksTable.getSelectedColumn());
            int selectedBookIndex = borrowBooksTable.getSelectedRow();
            if (selectedBookIndex == -1) {
                JOptionPane.showMessageDialog(null, "You have not selected a book to borrow.", "Error Message", JOptionPane.INFORMATION_MESSAGE);
            }
            String studentFullName = (String) selectStudentComboBox.getSelectedItem();
            LocalDate date = dateBorrowedDatePicker.getDate();
            //calls method in bookManager which adds a book to the borrowed table
            bm.addToBorrowedBooksTable(selectedBookValue, studentFullName, date);
            JOptionPane.showMessageDialog(null, "This book has been borrowed from the library.", "Confirmation Message", JOptionPane.INFORMATION_MESSAGE);
            try {
                setsReturnStudentComboBoxModel();
                populateReturnBooksTable();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(BookBuddy.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(BookBuddy.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookBuddy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookBuddy.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_markAsBorrowedButtonActionPerformed

    private void filterGradeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterGradeComboBoxActionPerformed
        try {
            if (filterGradeComboBox.getSelectedItem() == null) {

                DefaultComboBoxModel filterGradeModel = new DefaultComboBoxModel();
                ArrayList<String> names = sm.getStudentsNames();
                filterGradeModel.addAll(names);
                selectStudentComboBox.setModel(filterGradeModel);

            } else {
                DefaultComboBoxModel studentNameByGradeModel = new DefaultComboBoxModel();
                ArrayList<String> studentsByGrade = sm.getNamesFromGrade(Integer.parseInt((String) filterGradeComboBox.getSelectedItem()));
                studentNameByGradeModel.addAll(studentsByGrade);
                selectStudentComboBox.setModel(studentNameByGradeModel);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookBuddy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookBuddy.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_filterGradeComboBoxActionPerformed

    private void searchGenreComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchGenreComboBoxActionPerformed

        String[] borrowBooksColNames = new String[5];
        borrowBooksColNames[0] = "Title";
        borrowBooksColNames[1] = "Author";
        borrowBooksColNames[2] = "Genre";
        borrowBooksColNames[3] = "Average Rating";
        borrowBooksColNames[4] = "Available books";

        // gets data and populates table model, then sets table to table model
        Object[][] exploreBooksTableData;
        try {
            String genre = (String) searchGenreComboBox.getSelectedItem();
            exploreBooksTableData = bm.makeBooksFromGenreTable(genre);
            DefaultTableModel borrowBooksTableModel = new DefaultTableModel(exploreBooksTableData, borrowBooksColNames);
            exploreBooksTable.setModel(borrowBooksTableModel);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookBuddy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookBuddy.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_searchGenreComboBoxActionPerformed

    //ADD BOOK SCREEN POPS UP
    private void addBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBookButtonActionPerformed
        try {
            new AddBookPopup(this).setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookBuddy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookBuddy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addBookButtonActionPerformed

    //DELETES BOOK FROM DATABASE, THEN ARRAYLIST
    private void deleteBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBookButtonActionPerformed
        int selectedIndex = booksTable.getSelectedRow();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(null, "You have not selected a book to delete.", "Error Message", JOptionPane.ERROR_MESSAGE);
        }
        try {
            bm.deleteBook(selectedIndex);
            updatesBookTableInManageBooksScreen();
            JOptionPane.showMessageDialog(null, "Your book has been successfully deleted!", "Confirmation Message", JOptionPane.INFORMATION_MESSAGE);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookBuddy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookBuddy.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_deleteBookButtonActionPerformed

    private void addStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentButtonActionPerformed
        try {
            new AddStudentPopup(this).setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookBuddy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookBuddy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addStudentButtonActionPerformed

    private void removeStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeStudentButtonActionPerformed
        int selectedRowIndex = studentsTable.getSelectedRow();
        if (selectedRowIndex == -1) {
            JOptionPane.showMessageDialog(null, "You have not selected a student to remove.", "Error Message", JOptionPane.INFORMATION_MESSAGE);
        }
        try {
            sm.deleteBook(selectedRowIndex);
            populateStudentsTable();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookBuddy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookBuddy.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_removeStudentButtonActionPerformed

    private void editBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBookButtonActionPerformed
        int selectedRowIndex = booksTable.getSelectedRow();
        try {
            if (selectedRowIndex == -1) {
                JOptionPane.showMessageDialog(null, "You have not selected a book to edit.", "Error Message", JOptionPane.ERROR_MESSAGE);
            } else {
                new EditBookPopup(this, bm.setComponentsToEditBook(selectedRowIndex)).setVisible(true);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookBuddy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookBuddy.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_editBookButtonActionPerformed

    private void markAsReturnedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_markAsReturnedButtonActionPerformed
        new RateBookPopup(this).setVisible(true);
        String title = (String) returnBooksTable.getModel().getValueAt(returnBooksTable.getSelectedRow(), returnBooksTable.getSelectedColumn());
        String name = (String) returnedByComboBox.getSelectedItem();

        //Code used from Kevin Sadler on stackOverflow
        LocalDate dateReturned = dateReturnedDatePicker.getDate();
        Instant instant = Instant.from(dateReturned.atStartOfDay(ZoneId.of("GMT")));
        Date date = (Date) Date.from(instant);

        try {
            bm.returnBook(title, name, date);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookBuddy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookBuddy.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_markAsReturnedButtonActionPerformed

    public void getsCommentAndRatingForBook(int rating) {

    }
    private void editStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editStudentButtonActionPerformed
        int selectedStudentIndex = studentsTable.getSelectedRow();

        try {
            new EditStudentPopup(this, sm.setComponentsToEditStudent(selectedStudentIndex)).setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookBuddy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookBuddy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_editStudentButtonActionPerformed

    private void manageBooksScreenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageBooksScreenButtonActionPerformed
        informationTextArea.setText("Looking to add, edit or delete a book?"
                + "\n\nTo add a new book, simply press the 'add' button. A new screen will \n"
                + "popup where you can enter the values for the new book. Once all "
                + "\nvalues have been entered, click 'add book' and your book will be "
                + "\nadded to the library!\n\n"
                + "To edit a book, please remember to select a book from the table "
                + "\nand then click the 'edit' button. Here you will be able to change specific "
                + "\ndetails about the book.\n\n"
                + "To delete a book, remember to select a book from the table and then"
                + "\nclick the 'delete' button. Yup, it's that easy!");
    }//GEN-LAST:event_manageBooksScreenButtonActionPerformed

    private void borrowBookScreenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrowBookScreenButtonActionPerformed
        informationTextArea.setText("Does someone need to borrow a book from the library?\n\n"
                + "First, select a book to borrow from the table, and if you cannot\n"
                + "find the book you are looking for, type in key words from the title and"
                + "\nthe app will automatically find the book you are looking for!\n\n"
                + "Next, you will have to select the student who is borrowing the book\n"
                + "and finally, click the 'mark as taken out' button.");
    }//GEN-LAST:event_borrowBookScreenButtonActionPerformed

    private void returnBookScreenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBookScreenButtonActionPerformed
        informationTextArea.setText("If a student wishes to return a book...\n\n"
                + "The list of books to return will only display books that have been taken\nout of the library.\n\n"
                + "Firstly, select a book from the list to return and then select the \nstudent who returned it.\n\n"
                + "Then, select the date of when the book was returned.\n\n"
                + "The app will show you how many days overdue the book is and the fine due.");
    }//GEN-LAST:event_returnBookScreenButtonActionPerformed

    private void manageStudentScreenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageStudentScreenButtonActionPerformed
        informationTextArea.setText("Managing students is just as easy as managing books!\n\n"
                + "To add a new student to the system, click the 'add' and fill in \ntheir details. "
                + "Once the information has been enteered, click 'add'.\n\n"
                + "To edit a student's information, click the 'edit' button and update the \nstudent's information.\n\n"
                + "To remove a student from the system, remember to select a student before\nclicking the 'delete' button.");
    }//GEN-LAST:event_manageStudentScreenButtonActionPerformed

    private void exploreScreenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exploreScreenButtonActionPerformed
        informationTextArea.setText("If a student would like to find new books they can do so in 'explore'!\n\n"
                + "By searching the name of a book, author or even a specific genre, you\n"
                + "can find information on more books with the same genre, author and even\n "
                + "the highest rated books in the library. \n\n"
                + "You can also select a book from the table to view comments left by \nother students.");
    }//GEN-LAST:event_exploreScreenButtonActionPerformed

    private void returnedByComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnedByComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_returnedByComboBoxActionPerformed

    private void searchBookTitleTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBookTitleTextFieldKeyReleased
        String partialTitle = searchBookTitleTextField.getText();
        String[] borrowBooksColNames = new String[5];
        borrowBooksColNames[0] = "Title";
        borrowBooksColNames[1] = "Author";
        borrowBooksColNames[2] = "Genre";
        borrowBooksColNames[3] = "Average Rating";
        borrowBooksColNames[4] = "Available books";

        // gets data and populates table model, then sets table to table model
        Object[][] exploreBooksTableData;
        try {
            exploreBooksTableData = bm.makeExploreTableFromSearchingByTitle(partialTitle);
            DefaultTableModel borrowBooksTableModel = new DefaultTableModel(exploreBooksTableData, borrowBooksColNames);
            exploreBooksTable.setModel(borrowBooksTableModel);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookBuddy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookBuddy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchBookTitleTextFieldKeyReleased

    private void searchTitleTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTitleTextFieldKeyTyped

    }//GEN-LAST:event_searchTitleTextFieldKeyTyped

    private void searchTitleTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTitleTextFieldKeyReleased
        String partialTitle = searchTitleTextField.getText();
        String[] borrowBooksColNames = new String[3];
        borrowBooksColNames[0] = "Title";
        borrowBooksColNames[1] = "Author";
        borrowBooksColNames[2] = "Available books";

        // gets data and populates table model, then sets table to table model
        Object[][] borrowBooksTableData;
        try {
            borrowBooksTableData = bm.makeBorrowedBooksTable(partialTitle);
            DefaultTableModel borrowBooksTableModel = new DefaultTableModel(borrowBooksTableData, borrowBooksColNames);
            borrowBooksTable.setModel(borrowBooksTableModel);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookBuddy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookBuddy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchTitleTextFieldKeyReleased

    private void searchFavAuthorTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFavAuthorTextFieldKeyReleased
        String partialTitle = searchFavAuthorTextField.getText();
        String[] borrowBooksColNames = new String[3];
        borrowBooksColNames[0] = "Title";
        borrowBooksColNames[1] = "Author";
        borrowBooksColNames[2] = "Available books";

        // gets data and populates table model, then sets table to table model
        Object[][] borrowBooksTableData;
        try {
            borrowBooksTableData = bm.makeExploreTableFromSearchingByAuthor(partialTitle);
            DefaultTableModel borrowBooksTableModel = new DefaultTableModel(borrowBooksTableData, borrowBooksColNames);
            exploreBooksTable.setModel(borrowBooksTableModel);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookBuddy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookBuddy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchFavAuthorTextFieldKeyReleased

    private void returnBooksTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnBooksTableMouseClicked
        String bookName = (String) returnBooksTable.getModel().getValueAt(returnBooksTable.getSelectedRow(), returnBooksTable.getSelectedColumn());
        try {

            DefaultComboBoxModel studentReturnComboModel = new DefaultComboBoxModel();
            ArrayList<String> students = sm.getStudentsForBook(bookName);
            studentReturnComboModel.addAll(students);
            returnedByComboBox.setModel(studentReturnComboModel);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookBuddy.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(BookBuddy.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_returnBooksTableMouseClicked

    private void exploreBooksTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exploreBooksTableMouseClicked
        String title = (String) exploreBooksTable.getModel().getValueAt(exploreBooksTable.getSelectedRow(), exploreBooksTable.getSelectedColumn());
        try {
            commentsTextArea.setText(bm.getCommentOnASpecificBook(title));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookBuddy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookBuddy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_exploreBooksTableMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BookBuddy.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookBuddy.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookBuddy.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookBuddy.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new BookBuddy().setVisible(true);

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(BookBuddy.class
                            .getName()).log(Level.SEVERE, null, ex);

                } catch (SQLException ex) {
                    Logger.getLogger(BookBuddy.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBookButton;
    private javax.swing.JButton addStudentButton;
    private javax.swing.JLabel amountOwedLabel;
    private javax.swing.JTextField amountOwedTextField;
    private javax.swing.JLabel availableBooksToBorrowLabel;
    private javax.swing.JTable booksTable;
    private javax.swing.JLabel borrowBookLabel;
    private javax.swing.JButton borrowBookScreenButton;
    private javax.swing.JTable borrowBooksTable;
    private javax.swing.JLabel commentsLabel;
    private javax.swing.JTextArea commentsTextArea;
    private com.github.lgooddatepicker.components.DatePicker dateBorrowedDatePicker;
    private javax.swing.JLabel dateBorrowedErrorMessageLabel;
    private javax.swing.JLabel dateBorrowedLabel1;
    private com.github.lgooddatepicker.components.DatePicker dateReturnedDatePicker;
    private javax.swing.JLabel dateReturnedErrorMessage;
    private javax.swing.JLabel dateReturnedLabel;
    private javax.swing.JLabel daysOverdueLabel;
    private javax.swing.JTextField daysOverdueTextField;
    private javax.swing.JButton deleteBookButton;
    private javax.swing.JButton editBookButton;
    private javax.swing.JButton editStudentButton;
    private javax.swing.JTable exploreBooksTable;
    private javax.swing.JButton exploreScreenButton;
    private javax.swing.JLabel filterByGradeLabel;
    private javax.swing.JComboBox<String> filterGradeComboBox;
    private javax.swing.JLabel highestRatedBooksLabel1;
    private javax.swing.JTextArea highestRatedBooksTextArea1;
    private javax.swing.JLabel informationPageLabel;
    private javax.swing.JTextArea informationTextArea;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lookingForBooksLabel;
    private javax.swing.JLabel manageBooksLabel;
    private javax.swing.JButton manageBooksScreenButton;
    private javax.swing.JButton manageStudentScreenButton;
    private javax.swing.JLabel manageStudentsLabel;
    private javax.swing.JButton markAsBorrowedButton;
    private javax.swing.JButton markAsReturnedButton;
    private javax.swing.JLabel noticeLabel1;
    private javax.swing.JLabel noticeLabel2;
    private javax.swing.JButton removeStudentButton;
    private javax.swing.JLabel returnABookLabel;
    private javax.swing.JButton returnBookScreenButton;
    private javax.swing.JTable returnBooksTable;
    private javax.swing.JComboBox<String> returnedByComboBox;
    private javax.swing.JLabel returnedByLabel;
    private javax.swing.JTextField searchBookTitleTextField;
    private javax.swing.JTextField searchFavAuthorTextField;
    private javax.swing.JLabel searchFavouriteAuthorLabel;
    private javax.swing.JLabel searchFavouriteBookTitleLabel;
    private javax.swing.JLabel searchForBooksLabel;
    private javax.swing.JComboBox<String> searchGenreComboBox;
    private javax.swing.JLabel searchGenreLabel;
    private javax.swing.JTextField searchTitleTextField;
    private javax.swing.JComboBox<String> selectStudentComboBox;
    private javax.swing.JLabel selectStudentLabel;
    private javax.swing.JTable studentsTable;
    private javax.swing.JLabel takenOutBooksLabel;
    private javax.swing.JLabel weGotYouLabel;
    // End of variables declaration//GEN-END:variables
}
