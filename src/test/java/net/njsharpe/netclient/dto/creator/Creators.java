package net.njsharpe.netclient.dto.creator;

import lombok.Getter;

@Getter
public class Creators {

    private Creator[] items;
    private Pagination metadata;

    public class Pagination {

        private int totalItems;
        private int currentPage;
        private int pageSize;
        private int totalPages;
        private String nextPage;

    }

}
