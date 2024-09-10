import java.util.Datepublic class GetData{
	private String indSize
	private String category
	private int locationId
	private Long applicationId
	
	GetData(Long appId){
		
		applicationId = appId
		def indApplicationDetailsInstance = IndApplicationDetails.get(appId)
		Long investCap =  indApplicationDetailsInstance.indUser.indCapInvt
		if(investCap < (IndTypeMaster.findWhere(name:"small")).max){
			indSize = "small"
		}else if(investCap < (IndTypeMaster.findWhere(name:"medium")).max){
			indSize = "medium"		}
		
		category = indApplicationDetailsInstance.indUser.category.name
		
		locationId = indApplicationDetailsInstance.indUser.district.id
	}
	public String getIndSize(){
		return indSize
	}
	public String getCategory(){
		return category
	}
	public String getLocationId(){
		return locationId
	}
	public void routeApp(){
		GenXmlParser parser = new GenXmlParser()
		String office
			
			if(indSize =="small"){				def routeInstance=Route.findAll("from Route routeIns where routeIns.industrySize='small'")
								office = routeInstance[0].office
				
			}else if(indSize =="medium"){				def routeInstance=Route.findAll("from Route routeIns where routeIns.industrySize='medium'")
								office = routeInstance[0].office	
			}
		def grp = new GroupMaster()
		def grpList = GroupDistrictMaster.findAllByDistrict(DistrictMaster.get(locationId))
		
		for(int i=0;i<grpList.size();i++){
			
			if(((grpList.get(i)).group).office == OfficeMaster.findByPriority(office.toInteger())){
				
				grp = (grpList.get(i)).group
			}
		}		def applicationInstance = IndApplicationDetails.get(applicationId)	/*	def appPendingInst=ApplicationPendingDetails.findAll("from ApplicationPendingDetails apd where apd.application=?",[applicationInstance])		if(appPendingInst.size()>0){			for(int i=0;i<appPendingInst.size();i++){			appPendingInst[i].delete()		}			} */		println("grp............grp"+grp)			/////Code for app pending detail delete when app returned		 def app11 = ApplicationPendingDetails.find("from ApplicationPendingDetails apd where apd.application=? and apd.scrutinyStatus='In-Complete' and apd.completionStatus='In-Complete'",[IndApplicationDetails.get(applicationId)])		 def app12 = ApplicationPendingDetails.find("from ApplicationPendingDetails apd where apd.application=? and apd.scrutinyStatus='Complete' and apd.completionStatus='Completed'",[IndApplicationDetails.get(applicationId)])		 		 println("app11............app11"+app11)			 println("app12............app11"+app12)		        if(app11!=null){					        	println("INSIDE............app11"+app11)				   }		
		def roleVsActList = RoleVsActivity.findAllByActivity(RoleActivityMaster.findByActivityCode("001"))
		def routed = false		
		for(int i=0;i<roleVsActList.size();i++){			if(((roleVsActList.get(i)).role).group == grp){								if(app11){					app11.applicationStatus = "pending"					app11.scrutinyStatus = "In-Complete"					app11.completionStatus = "In-Complete"					if(app11.save(flush:true)){											}else{						app11.errors.each {		    		        println it		    		   }		    		}				}else if(app12)				{					app12.applicationStatus = "pending"					app12.scrutinyStatus = "Complete"					app12.completionStatus = "Complete"					if(app12.save(flush:true)){											}else{						app12.errors.each {		    		        println it		    		   }		    		}								}else{					def appVer = IndApplicationDetails.get(applicationId)					def pending = ApplicationPendingDetails.findByApplication(appVer)					def appPendDetails					if(pending){						appPendDetails=pending					}else{						appPendDetails = new ApplicationPendingDetails()					}				
				//def appPendDetails = new ApplicationPendingDetails()
				appPendDetails.application = IndApplicationDetails.get(applicationId)
				appPendDetails.applicationStatus = "pending"
				appPendDetails.role = (roleVsActList.get(i)).role
				appPendDetails.pendingWith = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole((roleVsActList.get(i)).role)).primaryEmployee)
				appPendDetails.completionDate = new Date()				appPendDetails.scrutinyStatus = ""				appPendDetails.completionStatus = ""					println("PENDING INSTANSE_--------------"+appPendDetails)				def empUser = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole((roleVsActList.get(i)).role)).primaryEmployee)								///////// SMS Code//////				def mobNo = empUser.userProfile.mobile				def appId = IndApplicationDetails.get(applicationId).toString()				//def appFor = appId.applicationType+" ("+appId.applicationFor+")"				SendSms sms = new SendSms()				sms.sendEmployeeForward12(appId,mobNo)				////////////////////				if(applicationInstance.certificateFor=="autoReNew")				{					appPendDetails.applicationStatus = "approved"					appPendDetails.completionStatus = "Complete";					appPendDetails.scrutinyStatus = "Complete";				}
				if(appPendDetails.save(flush:true)){
					routed = true
				}else{
					appPendDetails.errors.each {						println it
	    		   }
	    		}
				}				/*appPendDetails.application.completionStatus = "completed"				appPendDetails.application.applicationDate = new Date()				//new				appPendDetails.application.actualApplicationDate = new Date()*/								def industryApplicationDetailsInst = IndApplicationDetails.get(applicationId)				industryApplicationDetailsInst.completionStatus = "completed"				industryApplicationDetailsInst.applicationDate = new Date()//new//				industryApplicationDetailsInst.actualApplicationDate = new Date()				industryApplicationDetailsInst.save()
			}else{
				if(!routed){
					def industryApplicationDetailsInst = IndApplicationDetails.get(applicationId)
					industryApplicationDetailsInst.completionStatus = "orphan"					industryApplicationDetailsInst.applicationDate = new Date()//new					industryApplicationDetailsInst.actualApplicationDate = new Date()					industryApplicationDetailsInst.save()
				}
			}
		}
		
	}
public boolean routeApp(GroupMaster group){		println("here in routing.............")		String office		if(indSize =="small"){			def routeInstance=Route.findAll("from Route routeIns where routeIns.industrySize='small'")			office = routeInstance[0].office		}else if(indSize =="medium"){			def routeInstance=Route.findAll("from Route routeIns where routeIns.industrySize='medium'")			office = routeInstance[0].office		}	def grp = new GroupMaster()	def grpList = GroupDistrictMaster.findAllByDistrict(DistrictMaster.get(locationId))	println(".grpList.........."+grpList)	for(int i=0;i<grpList.size();i++){		def office1 = OfficeMaster.findByPriority(office.toInteger())			if(((grpList.get(i)).group).office.id == office1.id){			grp = (grpList.get(i)).group		}	}		println(".grp.........."+grp)
		def roleVsActList = RoleVsActivity.findAllByActivity(RoleActivityMaster.findByActivityCode("001"))		println("roleVsActList.111111111.."+roleVsActList)
		def routed = false
		for(int i=0;i<roleVsActList.size();i++){			println("roleVsActList.2222222222.."+((roleVsActList.get(i)).role).group)			println("roleVsActList.3333333333333.."+group)			println("((roleVsActList.get(i)).role).group.id..."+((roleVsActList.get(i)).role).group.id)			println("grp.id..."+grp.id)
			if(((roleVsActList.get(i)).role).group == group && ((roleVsActList.get(i)).role).group.id == grp.id ){
				def appPendDetails = new ApplicationPendingDetails()
				appPendDetails.application = IndApplicationDetails.get(applicationId)
				appPendDetails.applicationStatus = "pending"				//appPendDetails.application.applicationDate = new Date()
				appPendDetails.role = (roleVsActList.get(i)).role
				appPendDetails.pendingWith = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole((roleVsActList.get(i)).role)).primaryEmployee)
				appPendDetails.application.completionStatus = "completed"				appPendDetails.application.applicationDate = new Date()				appPendDetails.application.actualApplicationDate = new Date()				
				if(appPendDetails.save(flush:true)){
					routed = true/////////////////////////////added for allsummary report///////////////                    IndApplicationDetailsController inddetails=new IndApplicationDetailsController();                    inddetails.updateAllSummaryReport((appPendDetails.application.id).toString());                    ////////////////////////////////////////end/////////////////////
				}else{
					appPendDetails.errors.each {						println it
	    		   }
	    		}
				def industryApplicationDetailsInst = IndApplicationDetails.get(applicationId)				industryApplicationDetailsInst.completionStatus = "completed"				industryApplicationDetailsInst.applicationDate = new Date()//new				industryApplicationDetailsInst.actualApplicationDate = new Date()				if(industryApplicationDetailsInst.save()){}else{					industryApplicationDetailsInst.errors.each {						println it	    		   }	    		}
			}else{
				if(!routed){
					def industryApplicationDetailsInst = IndApplicationDetails.get(applicationId)
					industryApplicationDetailsInst.completionStatus = "orphan"					industryApplicationDetailsInst.applicationDate = new Date()
					industryApplicationDetailsInst.save()
				}
			}
		}
		return routed
	}//	 CODE BY VIKAS RATHORE	public boolean routeAppForAppReturn()	{println("inside routeAppForAppReturn")				GenXmlParser parser = new GenXmlParser()		String office		//if(category == "RED"){			if(indSize =="small"){				def routeInstance=Route.findAll("from Route routeIns where routeIns.industrySize='small'")				//office = parser.getValue("red_small","resources/route.xml")				office = routeInstance[0].office			}else if(indSize =="medium"){				def routeInstance=Route.findAll("from Route routeIns where routeIns.industrySize='medium'")				office = routeInstance[0].office				//office = parser.getValue("red_medium","resources/route.xml")			}//			else if(indSize =="large"){//				def routeInstance=Route.findAll("from Route routeIns where routeIns.industryCategory='RED'and routeIns.industrySize='large'")//				office = routeInstance[0].office//				office = parser.getValue("red_large","resources/route.xml")//			}		//}		//		else if(category == "GREEN"){//			if(indSize =="small"){//				def routeInstance=Route.findAll("from Route routeIns where routeIns.industryCategory='GREEN'and routeIns.industrySize='small'")//				office = routeInstance[0].office//				office = parser.getValue("green_small","resources/route.xml")//			}else if(indSize =="medium"){//				def routeInstance=Route.findAll("from Route routeIns where routeIns.industryCategory='GREEN'and routeIns.industrySize='medium'")//				office = routeInstance[0].office//				office = parser.getValue("green_medium","resources/route.xml")//			}else if(indSize =="large"){//				def routeInstance=Route.findAll("from Route routeIns where routeIns.industryCategory='GREEN'and routeIns.industrySize='large'")//				office = routeInstance[0].office//				office = parser.getValue("green_large","resources/route.xml")//			}//			//		}else if(category == "ORANGE"){//			if(indSize =="small"){//				def routeInstance=Route.findAll("from Route routeIns where routeIns.industryCategory='ORANGE'and routeIns.industrySize='small'")//				office = routeInstance[0].office//				office = parser.getValue("others_small","resources/route.xml")//			}else if(indSize =="medium"){//				def routeInstance=Route.findAll("from Route routeIns where routeIns.industryCategory='ORANGE'and routeIns.industrySize='medium'")//				office = routeInstance[0].office//				office = parser.getValue("others_medium","resources/route.xml")//			}else if(indSize =="large"){//				def routeInstance=Route.findAll("from Route routeIns where routeIns.industryCategory='ORANGE'and routeIns.industrySize='large'")//				office = routeInstance[0].office//				office = parser.getValue("others_large","resources/route.xml")//			}//			//		}		//GroupMaster.findAllByOffice()		def grp = new GroupMaster()		def grpList = GroupDistrictMaster.findAllByDistrict(DistrictMaster.get(locationId))		for(int i=0;i<grpList.size();i++){						if(((grpList.get(i)).group).office == OfficeMaster.findByPriority(office.toInteger())){				grp = (grpList.get(i)).group			}		}		def roleVsActList = RoleVsActivity.findAllByActivity(RoleActivityMaster.findByActivityCode("001"))		def routed = false						for(int i=0;i<roleVsActList.size();i++){			if(((roleVsActList.get(i)).role).group == grp){							//def appPendDetails = ApplicationPendingDetails.get(applicationId)			def	appPendDetails = ApplicationPendingDetails.find("from ApplicationPendingDetails indPower where indPower.application.id=? order by indPower.id desc",[applicationId])					 def app11 = ApplicationPendingDetails.find("from ApplicationPendingDetails apd where apd.application=? and apd.scrutinyStatus='In-Complete' and apd.completionStatus='In-Complete'",[IndApplicationDetails.get(applicationId)])		 def app12 = ApplicationPendingDetails.find("from ApplicationPendingDetails apd where apd.application=? and apd.scrutinyStatus='Complete' and apd.completionStatus='Completed'",[IndApplicationDetails.get(applicationId)])		 		 println("app11............app11"+app11)			 println("app12............app11"+app12)				appPendDetails.application = IndApplicationDetails.get(applicationId)				def applicationProcessingDetails = ApplicationProcessingDetails.find("from ApplicationProcessingDetails indPower where indPower.application.id=? order by indPower.id desc",[applicationId])								if(applicationProcessingDetails){					println("applicationProcessingDetails.returned=="+applicationProcessingDetails.returned)				if(applicationProcessingDetails.returned==true || applicationProcessingDetails.scrutinyStatus=='In-Complete'){					  println("routeAppForAppReturn applicationProcessingDetails returned true  ")			       applicationProcessingDetails.resubmitStatus = true			    			         //      applicationProcessingDetails.save()							}else if(appPendDetails.applicationStatus=="returned"){           // New code by Deepak					  println("routeAppForAppReturn appPendDetails returned status ")					  applicationProcessingDetails.returned=true					  applicationProcessingDetails.resubmitStatus = true									}				if(applicationProcessingDetails.save(flush:true)){					println("applicationProcessingDetails.resubmitStatus=="+applicationProcessingDetails.resubmitStatus)					}				else{					applicationProcessingDetails.errors.each {	    		        println it	    		   }	    		}			}				if(app11){					//app11.applicationStatus = "pending"					app11.scrutinyStatus = ""					app11.completionStatus = ""					if(app11.save(flush:true)){											}else{						app11.errors.each {		    		        println it		    		   }		    		}				}else if(app12)				{					//app12.applicationStatus = "pending"					app12.scrutinyStatus = "Complete"					app12.completionStatus = "Complete"					if(app12.save(flush:true)){											}else{						app12.errors.each {		    		        println it		    		   }		    		}								}				    appPendDetails.applicationStatus = "pending"									//appPendDetails.scrutinyStatus = ""//"In-Process"				   // appPendDetails.completionStatus = ""//"In-Process"								appPendDetails.role = (roleVsActList.get(i)).role				appPendDetails.pendingWith = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole((roleVsActList.get(i)).role)).primaryEmployee)				appPendDetails.completionDate = new Date()				def empUser = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole((roleVsActList.get(i)).role)).primaryEmployee)								///////// SMS Code//////				def mobNo = empUser.userProfile.mobile				def appId = IndApplicationDetails.get(applicationId).toString()				//def appFor = appId.applicationType+" ("+appId.applicationFor+")"				SendSms sms = new SendSms()				sms.sendEmployeeForward12(appId,mobNo)				////////////////////				if(appPendDetails.save(flush:true)){					routed = true				}else{					appPendDetails.errors.each {						println it	    		    }	    		}				def industryApplicationDetailsInst = IndApplicationDetails.get(applicationId)				industryApplicationDetailsInst.completionStatus = "completed"				industryApplicationDetailsInst.applicationDate = new Date()//new//				industryApplicationDetailsInst.actualApplicationDate = new Date()				industryApplicationDetailsInst.save()				if(industryApplicationDetailsInst.save(flush:true)){				}else{					industryApplicationDetailsInst.errors.each {						println it	    		    }	    		}				}else{				if(!routed){					def industryApplicationDetailsInst = IndApplicationDetails.get(applicationId)					industryApplicationDetailsInst.completionStatus = "orphan"				//	industryApplicationDetailsInst.applicationDate = new Date()//new				//	industryApplicationDetailsInst.actualApplicationDate = new Date()					industryApplicationDetailsInst.save()				}			}		}				}	//CODE ENDED BY VIKAS RATHORE
}