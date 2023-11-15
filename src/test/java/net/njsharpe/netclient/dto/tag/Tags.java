package net.njsharpe.netclient.dto.tag;

import lombok.Getter;

@Getter
public class Tags {

    private Tag[] items;
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
