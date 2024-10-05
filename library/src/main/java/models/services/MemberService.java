package models.services;

import exception.DefaultException;
import models.dao.DaoFactory;
import models.dao.impl.MemberDaoJ;
import models.entities.persons.Member;

import java.util.List;

public class MemberService {

    private final MemberDaoJ memberDao = DaoFactory.createMemberDao();

    public MemberService() {
    }

    public void newMember(Member member) {

        Member m = searchMember(member.getEmail());
        if (m != null) {
            throw new DefaultException("Member: " + m.getName() + " already exists!");
        }

        memberDao.insert(member);
    }

    public void updateMember(Member member) {
        memberDao.update(member);
    }

    public void deleteMember(String name){
        memberDao.deleteByName(name);
    }

    public Member searchMember(Integer id) {
        return memberDao.findById(id);
    }

    public Member searchMember(String email) {
        return memberDao.findByName(email);
    }

    public List<Member> listMembers() {
        return memberDao.findAll();
    }
}
