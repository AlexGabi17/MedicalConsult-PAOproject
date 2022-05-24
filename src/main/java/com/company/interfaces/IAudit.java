package com.company.interfaces;

public interface IAudit {
    public void writeAudit(String command,String entityType, int numberOfInsertions);
}
