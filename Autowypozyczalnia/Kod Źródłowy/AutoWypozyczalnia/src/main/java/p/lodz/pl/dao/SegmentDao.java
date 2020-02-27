package p.lodz.pl.dao;

import java.util.List;

import p.lodz.pl.encje.Segment;

public interface SegmentDao {
	List<Segment> findAll();
	Segment findSegment(String rodzaj);
	Segment findByCena(int CenaZaDobe);
}
