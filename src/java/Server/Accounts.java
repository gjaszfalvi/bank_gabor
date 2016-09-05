/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author x15034593
 */
@Entity
@Table(name = "accounts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accounts.findAll", query = "SELECT a FROM Accounts a"),
    @NamedQuery(name = "Accounts.findByAccountId", query = "SELECT a FROM Accounts a WHERE a.accountId = :accountId"),
    @NamedQuery(name = "Accounts.findCustomerTransactions", query = "SELECT o FROM Accounts o WHERE o.fKCustomerId.id = :JMC"),
    @NamedQuery(name = "Accounts.balance", query = "SELECT a.balance FROM Accounts a WHERE a.accountId = :JMC"),    
    @NamedQuery(name = "Accounts.findBySortCode", query = "SELECT a FROM Accounts a WHERE a.sortCode = :sortCode"),
    @NamedQuery(name = "Accounts.findByAccountNr", query = "SELECT a FROM Accounts a WHERE a.accountNr = :accountNr"),
    @NamedQuery(name = "Accounts.findByBalance", query = "SELECT a FROM Accounts a WHERE a.balance = :balance")})
public class Accounts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "accountId")
    private Integer accountId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sortCode")
    private int sortCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "accountNr")
    private int accountNr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "balance")
    private long balance;
    @JoinColumn(name = "FKCustomerId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Customers fKCustomerId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fKAccountId")
    private Collection<Transactions> transactionsCollection;

    public Accounts() {
    }

    public Accounts(Integer accountId) {
        this.accountId = accountId;
    }

    public Accounts(Integer accountId, int sortCode, int accountNr, long balance) {
        this.accountId = accountId;
        this.sortCode = sortCode;
        this.accountNr = accountNr;
        this.balance = balance;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public int getSortCode() {
        return sortCode;
    }

    public void setSortCode(int sortCode) {
        this.sortCode = sortCode;
    }

    public int getAccountNr() {
        return accountNr;
    }

    public void setAccountNr(int accountNr) {
        this.accountNr = accountNr;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public Customers getFKCustomerId() {
        return fKCustomerId;
    }

    public void setFKCustomerId(Customers fKCustomerId) {
        this.fKCustomerId = fKCustomerId;
    }

    @XmlTransient
    public Collection<Transactions> getTransactionsCollection() {
        return transactionsCollection;
    }

    public void setTransactionsCollection(Collection<Transactions> transactionsCollection) {
        this.transactionsCollection = transactionsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountId != null ? accountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accounts)) {
            return false;
        }
        Accounts other = (Accounts) object;
        if ((this.accountId == null && other.accountId != null) || (this.accountId != null && !this.accountId.equals(other.accountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Server.Accounts[ accountId=" + accountId + " ]";
    }
    
}
