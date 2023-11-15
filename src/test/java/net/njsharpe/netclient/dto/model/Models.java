package net.njsharpe.netclient.dto.model;

import lombok.Getter;

@Getter
public class Models {

    private Model[] items;
    private Pagination metadata;

    @Getter
    public class Pagination {

        private int totalItems;
        private int currentPage;
        private int pageSize;
        private int totalPages;
        private String nextPage;
        private String prevPage;

    }

}