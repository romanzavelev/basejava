package com.urise.webapp.model;

import java.util.List;
import java.util.Objects;

public class CompanySection extends AbstractSection {

    private final List<Company> companies;

    CompanySection(List<Company> companies) {
        Objects.requireNonNull(companies, "organizations must non be null");
        this.companies = companies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanySection that = (CompanySection) o;
        return companies.equals(that.companies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companies);
    }
}
