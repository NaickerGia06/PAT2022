/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BackendDatatypes.Book;
import BackendDatatypes.Student;
import BackendManagerClasses.BookManager;
import BackendManagerClasses.StudentManager;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
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

        //BOOK MANAGER CLASS
        //populates GENRE COMBOBOX
        populateGenreComboBox();

        //populates BOOKS TABLE during runTime
        updatesBookTableInManageBooksScreen();

        //populates LIST with book titles
        populateListWithBookTitlesModel();

        //populates borrowBooksTableWhenRun
        populateBorrowBooksTableOnRun();

        //STUDENT MANAGER CLASS
        try { // make these into their own method later
            sm = new StudentManager();
            DefaultComboBoxModel filterGradeModel = new DefaultComboBoxModel();
            ArrayList<String> grades = sm.getGrades();
            filterGradeModel.addAll(grades);

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
        Object[][] booksData = bm.makeBooksTableForBookManagement();
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

    public void populateListWithBookTitlesModel() throws ClassNotFoundException, SQLException {
        bm = new BookManager();
        DefaultListModel listModel = new DefaultListModel();
        ArrayList<String> bookTitles = bm.getBookNames();
        listModel.addAll(bookTitles);
    }

    public void populateGenreComboBox() throws ClassNotFoundException, SQLException {
        bm = new BookManager();
        DefaultComboBoxModel comboModel = new DefaultComboBoxModel();
        ArrayList<String> genres = bm.getGenres();
        comboModel.addAll(genres);
    }

    //STUDENTS
    public void populateStudentsTable() throws ClassNotFoundException, SQLException {
        sm = new StudentManager();
        String[] coloumNamesForStudentTbl = new String[3];
        coloumNamesForStudentTbl[0] = "Name";
        coloumNamesForStudentTbl[1] = "Surname";
        coloumNamesForStudentTbl[2] = "Grade";

        // gets data and populates table model, then sets table to table model
        Object[][] studentData = sm.makeStudentTable();
        DefaultTableModel bookModel = new DefaultTableModel(studentData, coloumNamesForStudentTbl);
        studentsTable.setModel(bookModel);
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
        jScrollPane8 = new javax.swing.JScrollPane();
        takenOutBooksList = new javax.swing.JList<>();
        dateReturnedLabel = new javax.swing.JLabel();
        returnedByLabel = new javax.swing.JLabel();
        dateReturnedDatePicker = new com.github.lgooddatepicker.components.DatePicker();
        amountOwedLabel = new javax.swing.JLabel();
        markAsReturnedButton = new javax.swing.JButton();
        amountOwedTextField = new javax.swing.JTextField();
        daysOverdueLabel = new javax.swing.JLabel();
        daysOverdueTextField = new javax.swing.JTextField();
        returnedByComboBox = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        lookingForBooksLabel = new javax.swing.JLabel();
        weGotYouLabel = new javax.swing.JLabel();
        searchFavouriteBookTitleLabel = new javax.swing.JLabel();
        searchBookTitleTextField = new javax.swing.JTextField();
        searchTitleButton = new javax.swing.JButton();
        youMightLikeLabel1 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        moreRecommendedBooksTextArea = new javax.swing.JTextArea();
        searchGenreLabel = new javax.swing.JLabel();
        searchGenreComboBox = new javax.swing.JComboBox<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        recommendedBooksTable = new javax.swing.JTable();
        searchFavouriteAuthorLabel = new javax.swing.JLabel();
        searchFavAuthorTextField = new javax.swing.JTextField();
        searchFavAuthorButton = new javax.swing.JButton();
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
        dateBorrowedErrorMessageLabel.setText("This is for error messages");
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
        ));
        jScrollPane3.setViewportView(borrowBooksTable);

        searchTitleTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTitleTextFieldActionPerformed(evt);
            }
        });
        searchTitleTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchTitleTextFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTitleTextFieldKeyReleased(evt);
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
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                        .addComponent(markAsBorrowedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
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

        takenOutBooksList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane8.setViewportView(takenOutBooksList);

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

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(returnABookLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(takenOutBooksLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(returnedByLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateReturnedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(markAsReturnedButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(amountOwedLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                        .addComponent(daysOverdueLabel)
                                        .addGap(61, 61, 61)))
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(daysOverdueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(amountOwedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(149, 149, 149)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(returnedByComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dateReturnedDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(60, 60, 60))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(returnABookLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dateReturnedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateReturnedDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(returnedByLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(returnedByComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(daysOverdueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(daysOverdueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(amountOwedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(amountOwedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(markAsReturnedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                        .addComponent(takenOutBooksLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Return a book", jPanel8);

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

        searchTitleButton.setText("Search");

        youMightLikeLabel1.setText("Comments:");
        youMightLikeLabel1.setFont(new java.awt.Font("Impact", 0, 15)); // NOI18N
        youMightLikeLabel1.setForeground(new java.awt.Color(0, 0, 0));

        moreRecommendedBooksTextArea.setColumns(20);
        moreRecommendedBooksTextArea.setEditable(false);
        moreRecommendedBooksTextArea.setRows(5);
        jScrollPane6.setViewportView(moreRecommendedBooksTextArea);

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

        recommendedBooksTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(recommendedBooksTable);

        searchFavouriteAuthorLabel.setText("Search authors:");
        searchFavouriteAuthorLabel.setBackground(new java.awt.Color(255, 255, 255));
        searchFavouriteAuthorLabel.setFont(new java.awt.Font("Impact", 0, 15)); // NOI18N
        searchFavouriteAuthorLabel.setForeground(new java.awt.Color(0, 0, 0));

        searchFavAuthorButton.setText("Search");
        searchFavAuthorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFavAuthorButtonActionPerformed(evt);
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
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(searchFavouriteAuthorLabel)
                                    .addComponent(searchFavouriteBookTitleLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(searchBookTitleTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                    .addComponent(searchFavAuthorTextField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(searchFavAuthorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(searchTitleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(searchGenreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(searchGenreComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(28, 28, 28))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(weGotYouLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(youMightLikeLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(27, 27, 27)
                .addComponent(lookingForBooksLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(youMightLikeLabel1)
                    .addComponent(weGotYouLabel))
                .addGap(11, 11, 11)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchTitleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchBookTitleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchFavouriteBookTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchFavouriteAuthorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchFavAuthorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchFavAuthorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchGenreComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchGenreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(highestRatedBooksLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Explore", jPanel7);

        informationPageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        informationPageLabel.setText("Information Page / Help");
        informationPageLabel.setFont(new java.awt.Font("Impact", 0, 50)); // NOI18N
        informationPageLabel.setForeground(new java.awt.Color(0, 0, 0));

        informationTextArea.setColumns(20);
        informationTextArea.setRows(5);
        jScrollPane2.setViewportView(informationTextArea);

        manageBooksScreenButton.setText("Manage Books");

        manageStudentScreenButton.setText("Manage Students");

        borrowBookScreenButton.setText("Borrow A Book");

        returnBookScreenButton.setText("Return A Book");

        exploreScreenButton.setText("Explore");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(informationPageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
                        .addGap(39, 39, 39))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(manageBooksScreenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(manageStudentScreenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(borrowBookScreenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(returnBookScreenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(exploreScreenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(informationPageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(manageBooksScreenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(manageStudentScreenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(borrowBookScreenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(returnBookScreenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(exploreScreenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addContainerGap(73, Short.MAX_VALUE))
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
        int selectedBookIndex = borrowBooksTable.getSelectedRow();
        if (selectedBookIndex == -1) {
            JOptionPane.showMessageDialog(null, "You have not selected a book to borrow.", "Error Message", JOptionPane.INFORMATION_MESSAGE);
        }
        String studentFullName = (String) selectStudentComboBox.getSelectedItem();
        LocalDate date = dateBorrowedDatePicker.getDate();

        try {
            //calls method in bookManager which adds a book to the borrowed table
            bm.addToBorrowedBooksTable(selectedBookIndex, studentFullName, date);
            JOptionPane.showMessageDialog(null, "This book has been borrowed from the library.", "Confirmation Message", JOptionPane.INFORMATION_MESSAGE);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookBuddy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookBuddy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_markAsBorrowedButtonActionPerformed

    private void searchFavAuthorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFavAuthorButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFavAuthorButtonActionPerformed

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
        try {
            String[] bookInfoColNames = new String[6];
            bookInfoColNames[0] = "Title";
            bookInfoColNames[1] = "Author";
            bookInfoColNames[2] = "Genre";
            bookInfoColNames[3] = "Rating";
            bookInfoColNames[4] = "Available books";

            // gets data and populates table model, then sets table to table model
            String gen = (String) searchGenreComboBox.getSelectedItem();
            Object[][] data = bm.makeBooksFromGenreTable(gen);
            DefaultTableModel bookInfoTableModel = new DefaultTableModel(data, bookInfoColNames);
            recommendedBooksTable.setModel(bookInfoTableModel);
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
            JOptionPane.showMessageDialog(null, "You have not selected a book to delete.", "Error Message", JOptionPane.INFORMATION_MESSAGE);
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
                new EditBookPopup(this).setVisible(true);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookBuddy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookBuddy.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_editBookButtonActionPerformed

    private void searchTitleTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTitleTextFieldKeyPressed

    }//GEN-LAST:event_searchTitleTextFieldKeyPressed

    private void searchTitleTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTitleTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTitleTextFieldActionPerformed

    private void searchTitleTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTitleTextFieldKeyReleased
        String partialTitle = searchTitleTextField.getText();
        String[] borrowBooksColNames = new String[3];
        borrowBooksColNames[0] = "Title";
        borrowBooksColNames[1] = "Author";
        borrowBooksColNames[2] = "Available books";

        // gets data and populates table model, then sets table to table model
        Object[][] borrowBooksTableData = bm.makeBorrowedBooksTable(partialTitle);
        DefaultTableModel borrowBooksTableModel = new DefaultTableModel(borrowBooksTableData, borrowBooksColNames);
        borrowBooksTable.setModel(borrowBooksTableModel);
    }//GEN-LAST:event_searchTitleTextFieldKeyReleased

    public void setBorrowBooksTableModel() {

    }
    private void markAsReturnedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_markAsReturnedButtonActionPerformed
        new RateBookPopup().setVisible(true);
    }//GEN-LAST:event_markAsReturnedButtonActionPerformed

    private void editStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editStudentButtonActionPerformed
        int selectedStudentIndex = studentsTable.getSelectedRow();
    }//GEN-LAST:event_editStudentButtonActionPerformed

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
            java.util.logging.Logger.getLogger(BookBuddy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookBuddy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookBuddy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookBuddy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new BookBuddy().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(BookBuddy.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(BookBuddy.class.getName()).log(Level.SEVERE, null, ex);
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
    private com.github.lgooddatepicker.components.DatePicker dateBorrowedDatePicker;
    private javax.swing.JLabel dateBorrowedErrorMessageLabel;
    private javax.swing.JLabel dateBorrowedLabel1;
    private com.github.lgooddatepicker.components.DatePicker dateReturnedDatePicker;
    private javax.swing.JLabel dateReturnedLabel;
    private javax.swing.JLabel daysOverdueLabel;
    private javax.swing.JTextField daysOverdueTextField;
    private javax.swing.JButton deleteBookButton;
    private javax.swing.JButton editBookButton;
    private javax.swing.JButton editStudentButton;
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
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lookingForBooksLabel;
    private javax.swing.JLabel manageBooksLabel;
    private javax.swing.JButton manageBooksScreenButton;
    private javax.swing.JButton manageStudentScreenButton;
    private javax.swing.JLabel manageStudentsLabel;
    private javax.swing.JButton markAsBorrowedButton;
    private javax.swing.JButton markAsReturnedButton;
    private javax.swing.JTextArea moreRecommendedBooksTextArea;
    private javax.swing.JLabel noticeLabel1;
    private javax.swing.JLabel noticeLabel2;
    private javax.swing.JTable recommendedBooksTable;
    private javax.swing.JButton removeStudentButton;
    private javax.swing.JLabel returnABookLabel;
    private javax.swing.JButton returnBookScreenButton;
    private javax.swing.JComboBox<String> returnedByComboBox;
    private javax.swing.JLabel returnedByLabel;
    private javax.swing.JTextField searchBookTitleTextField;
    private javax.swing.JButton searchFavAuthorButton;
    private javax.swing.JTextField searchFavAuthorTextField;
    private javax.swing.JLabel searchFavouriteAuthorLabel;
    private javax.swing.JLabel searchFavouriteBookTitleLabel;
    private javax.swing.JLabel searchForBooksLabel;
    private javax.swing.JComboBox<String> searchGenreComboBox;
    private javax.swing.JLabel searchGenreLabel;
    private javax.swing.JButton searchTitleButton;
    private javax.swing.JTextField searchTitleTextField;
    private javax.swing.JComboBox<String> selectStudentComboBox;
    private javax.swing.JLabel selectStudentLabel;
    private javax.swing.JTable studentsTable;
    private javax.swing.JLabel takenOutBooksLabel;
    private javax.swing.JList<String> takenOutBooksList;
    private javax.swing.JLabel weGotYouLabel;
    private javax.swing.JLabel youMightLikeLabel1;
    // End of variables declaration//GEN-END:variables
}
