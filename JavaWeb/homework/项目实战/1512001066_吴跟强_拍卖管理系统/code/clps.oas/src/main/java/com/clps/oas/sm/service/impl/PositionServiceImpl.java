package com.clps.oas.sm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.oas.common.ParamCommon;
import com.clps.oas.sm.dao.PositionMapper;
import com.clps.oas.sm.pojo.Position;
import com.clps.oas.sm.service.IPositionService;

@Service("positionService")
public class PositionServiceImpl implements IPositionService{

	@Autowired
	private PositionMapper positionDao;
	@Override
	public String savePosition(Position position) {
		if(position!=null)
		{
			if(positionDao.insertPosition(position)>0)
			{
				return ParamCommon.ADD_SUCCESS;
			}else{
				return ParamCommon.ADD_FAILURE;
			}
			
		}
		return ParamCommon.ADD_EMPTY;
	}

	@Override
	public String updatePosition(Position position) {
		try {
			this.positionDao.updatePosition(position);
		} catch (Exception e) {
			e.printStackTrace();
			}
		return null;
		}

	@Override
	public Position queryPositionById(int positionId) {
		try {
			this.positionDao.queryPositionById(positionId);
		} catch (Exception e) {
			e.printStackTrace();
			}
		return positionDao.queryPositionById(positionId);
		}
				

	@Override
	public List<Position> queryAllPosition() {
		try {
			this.positionDao.queryAllPositions();
		} catch (Exception e) {
			e.printStackTrace();
			}
		return positionDao.queryAllPositions();
	}

	@Override
	public List<Position> queryPositionByName(String positionName) {
		try {
			this.positionDao.queryPositionByName(positionName);
		} catch (Exception e) {
			e.printStackTrace();
			}
		return positionDao.queryAllPositions();
	}

	@Override
	public int deletePositionbyId(int positionId) {
		return positionDao.deletePositionById(positionId);
	}

}
