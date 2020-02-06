<?php

namespace App\Model;

use Illuminate\Database\Eloquent\Model;

class Registration extends Model
{
    protected $fillable=['package','group_type','group_name','start_cycle_date','end_cycle_date','member_name','phone_number','address','email_address'];
    
}
