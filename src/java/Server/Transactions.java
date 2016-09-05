/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author x15034593
 */
@Entity
@Table(name = "transactions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transactions.findAll", query = "SELECT t FROM Transactions t"),
    @NamedQuery(name = "Transactions.findByTransactionId", query = "SELECT t FROM Transactions t WHERE t.transactionId = :transactionId"),
    @NamedQuery(name = "Transactions.findByTransactionDetails", query = "SELECT t FROM Transactions t WHERE t.transactionDetails = :transactionDetails"),
    @NamedQuery(name = "Transactions.findByTransactionDate", query = "SELECT t FROM Transactions t WHERE t.transactionDate = :transactionDate"),
    @NamedQuery(name = "Transactions.findByPostBalance", query = "SELECT t FROM Transactions t WHERE t.postBalance = :postBalance"),
    @NamedQuery(name = "Transactions.findByTransactionAmount", query = "SELECT t FROM Transactions t WHERE t.transactionAmount = :transactionAmount")})
public class Transactions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "transactionId")
    private Integer transactionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 140)
    @Column(name = "transactionDetails")
    private String transactionDetails;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "transactionDate")
    private String transactionDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "postBalance")
    private long postBalance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "transactionAmount")
    private long transactionAmount;
    @JoinColumn(name = "FKAccountId", referencedColumnName = "accountId")
    @ManyToOne(optional = false)
    private Accounts fKAccountId;

    public Transactions() {
    }

    public Transactions(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Transactions(Integer transactionId, String transactionDetails, String transactionDate, long postBalance, long transactionAmount) {
        this.transactionId = transactionId;
        this.transactionDetails = transactionDetails;
        this.transactionDate = transactionDate;
        this.postBalance = postBalance;
        this.transactionAmount = transactionAmount;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionDetails() {
        return transactionDetails;
    }

    public void setTransactionDetails(String transactionDetails) {
        this.transactionDetails = transactionDetails;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public long getPostBalance() {
        return postBalance;
    }

    public void setPostBalance(long postBalance) {
        this.postBalance = postBalance;
    }

    public long getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(long transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Accounts getFKAccountId() {
        return fKAccountId;
    }

    public void setFKAccountId(Accounts fKAccountId) {
        this.fKAccountId = fKAccountId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionId != null ? transactionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transactions)) {
            return false;
        }
        Transactions other = (Transactions) object;
        if ((this.transactionId == null && other.transactionId != null) || (this.transactionId != null && !this.transactionId.equals(other.transactionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Server.Transactions[ transactionId=" + transactionId + " ]";
    }
    
}
