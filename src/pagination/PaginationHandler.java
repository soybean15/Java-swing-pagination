/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pagination;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import javax.swing.JLabel;
import pagination.listener.CustomComponentListener;
import javax.swing.JPanel;
import pagination.event.PaginationEvent;
import pagination.listener.PaginationMouseListener;

/**
 *
 * @author root
 */
public class PaginationHandler implements CustomComponentListener {

    private final Pagination PAGINATION;
    private final PaginationComponent COMPONENT;
    private JPanel CONTAINER;
    private final int totalItems;

    /**
     *
     * @param set how many items you want to show per page
     * @param totalItems total item of data you want to fetch
     * @param numberOfPageToShow how many page button you want to display
     */
    public PaginationHandler(int set, int totalItems, int numberOfPageToShow) {

        this.PAGINATION = new Pagination(set, totalItems == 0 ? 1 : totalItems, numberOfPageToShow < 5 ? 5 : numberOfPageToShow);
        COMPONENT = new PaginationComponent(numberOfPageToShow < 5 ? 5 : numberOfPageToShow);
        this.totalItems = totalItems;
        addListener();
        createPagination();
        COMPONENT.addMouseListener(new PaginationMouseListener() {
            @Override
            public void onClick(PaginationEvent e) {

            }

        });

    }

    public void addListener() {
        COMPONENT.addListener(this);
    }

    public void addMouseListener(PaginationMouseListener listener) {
        COMPONENT.addMouseListener(listener);
    }

    private void createPagination() {

        CONTAINER = COMPONENT.createPages(
                PAGINATION.start(),
                PAGINATION.end(),
                PAGINATION.onFirst(),
                PAGINATION.onLast()
        );

        CONTAINER.setVisible(totalItems != 0);

    }

    public JPanel getPagination() {

        return CONTAINER;

    }

    public void modifyButton(Consumer<JLabel> c) {
        COMPONENT.modifyButton(c);
    }

    public void modifyNextAndPreviousButton(BiConsumer<JLabel, JLabel> c) {
        COMPONENT.modifyPreviousAndNextButton(c);
    }

    @Override
    public PaginationEvent onClick() {
        return new PaginationEvent(PAGINATION);
    }

    @Override
    public void onNext() {
        PAGINATION.onNext();
        loadPages();
    }

    @Override
    public void onPrevious() {
        PAGINATION.onPrevious();
        loadPages();
    }

    private void loadPages() {
        COMPONENT.createPages(
                PAGINATION.start(),
                PAGINATION.end(),
                PAGINATION.onFirst(),
                PAGINATION.onLast()
        );
    }

}
