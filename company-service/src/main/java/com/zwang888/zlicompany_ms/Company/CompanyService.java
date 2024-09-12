package com.zwang888.zlicompany_ms.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    void addCompany(Company company);
    boolean updateCompany(Company company, Long id);
    boolean deleteCompany(Long id);
    Company getCompanyById(Long id);
}
