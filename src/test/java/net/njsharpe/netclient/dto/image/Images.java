package net.njsharpe.netclient.dto.image;

import lombok.Getter;

@Getter
public class Images {

    private Image[] items;
    private Pagination metadata;

    public class Pagination {

        private int nextCursor;
        private String nextPage;

    }

}
