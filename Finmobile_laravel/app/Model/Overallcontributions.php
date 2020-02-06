<?php

namespace App\Model;

use Illuminate\Database\Eloquent\Model;

class Overallcontributions extends Model
{
    protected $fillable=['member_name','monthly_contributions','socialwelfare','fines','loan_obtained','interest(15%)','due_loan_repayment'];
}
